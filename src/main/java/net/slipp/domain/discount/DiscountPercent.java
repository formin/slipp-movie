package net.slipp.domain.discount;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DiscountPercent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int percentId = 1;
	
	@OneToOne
	@org.hibernate.annotations.ForeignKey(name = "fk_discountpercent_parent_id")
	private Discount discountId;
	 
	@Column(name="PERCENT", nullable=false)
	private String percent;
 
	public DiscountPercent() {
	}
	
	DiscountPercent(String percent) {
		this.percent = percent;  
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}
 
}
