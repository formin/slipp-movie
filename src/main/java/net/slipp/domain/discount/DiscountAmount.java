package net.slipp.domain.discount;

import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
 
@Entity
public class DiscountAmount {

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
