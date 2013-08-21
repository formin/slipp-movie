package net.slipp.domain.movie;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Money {

	@Column(name = "fee_amount", nullable = false)
	private String feeAmount;

	@Column(name = "fee_currency", nullable = false)
	private String feeCurrency;


	public Money() {
	}
	
	Money(String feeAmount, String feeCurrency) {
		this.feeAmount = feeAmount; 
		this.feeCurrency = feeCurrency; 
	}
	
	public String getFeeAmout() {
		return feeAmount;
	}

	public void setFeeAmout(String feeAmount) {
		this.feeAmount = feeAmount;
	}

	public String getFeeCurrency() {
		return feeCurrency;
	}

	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	}
	
}
