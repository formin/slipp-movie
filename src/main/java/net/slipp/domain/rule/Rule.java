package net.slipp.domain.rule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import net.slipp.domain.discount.Discount; 

@Entity
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int RuleId = 1;

	@Column(name = "position", nullable = false)
	private String position;

	@Column(name = "rule_type", nullable = false)
	private String ruleType;

	@Column(name = "day_of_week", nullable = false)
	private String dayOfWeek;

	@Column(name = "start_time", nullable = false)
	private String startTime;

	@Column(name = "end_time", nullable = false)
	private String endTime;

	@Column(name = "sequence", nullable = false)
	private String sequence;
	
	@ManyToOne
	@org.hibernate.annotations.ForeignKey(name = "fk_rule_parent_id")
	private Discount discount;
	
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1; 
		result = prime * result + ((ruleType == null) ? 0 : ruleType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule other = (Rule) obj;
		if (!ruleType.equals(other.ruleType))
			return false;
		return true;
	}
}
