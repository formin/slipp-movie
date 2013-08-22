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
public abstract class DiscountAmount {

	private static final String discountAmount = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int amountId = 1;
	
	@OneToOne
	@org.hibernate.annotations.ForeignKey(name = "fk_discountamount_parent_id")
	private Discount discountId;
	 
	@Column(name="FEE_AMOUNT", nullable=false)
	private String feeAmount;

	@Column(name="FEE_CURRENCY", nullable=false)
	private String feeCurrency;

	public DiscountAmount() {
	}
	
	DiscountAmount(String feeAmount, String feeCurrency) {
		this.feeAmount = feeAmount; 
		this.feeCurrency = feeCurrency; 
	}

	protected Money getDiscountedFee(Showing showing){
		return showing.getFixedFee().minus(discountAmount);
	}
	
	public String getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}

	public String getFeeCurrency() {
		return feeCurrency;
	}

	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	}
	
}
