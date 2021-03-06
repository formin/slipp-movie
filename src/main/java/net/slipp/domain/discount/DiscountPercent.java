package net.slipp.domain.discount;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import net.slipp.domain.movie.Money;
import net.slipp.domain.showing.Showing;

@Entity
public abstract class DiscountPercent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int percentId = 1;
	
	@OneToOne
	@org.hibernate.annotations.ForeignKey(name = "fk_discountpercent_parent_id")
	private Discount discountId;
	 
	@Column(name="PERCENT", nullable=false)
	private String percent;
 

	protected Money getDiscountedFee(Showing showing){
		return showing.getFixedFee().minus(showing.getFixedFee().times(percent));
	}
	
	
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
