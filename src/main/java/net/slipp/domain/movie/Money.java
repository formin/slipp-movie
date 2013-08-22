package net.slipp.domain.movie;

import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Money {

	@Column(name = "fee_amount", nullable = false)
	private BigDecimal amount;

	@Column(name = "fee_currency", nullable = false)
	private Currency currency;


	public Money() {
	}
	
	Money(BigDecimal feeAmount, Currency feeCurrency) {
		this.amount = feeAmount; 
		this.currency = feeCurrency; 
	}
	
	public BigDecimal getFeeAmout() {
		return amount;
	}

	public void setFeeAmout(BigDecimal feeAmount) {
		this.amount = feeAmount;
	}

	public Currency getFeeCurrency() {
		return currency;
	}

	public void setFeeCurrency(Currency feeCurrency) {
		this.currency = feeCurrency;
	}

	public String times(int audienceCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public Money minus(String discountamount) {
		// TODO Auto-generated method stub
		return null;
	}

	public String times(String percent) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
