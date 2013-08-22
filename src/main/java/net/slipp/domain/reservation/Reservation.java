package net.slipp.domain.reservation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import net.slipp.domain.showing.Showing;
import net.slipp.domain.user.User;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reservationId = 1;

	@Column(name = "fee_amount", nullable = false)
	private String feeAmount;

	@Column(name = "fee_currency", nullable = false)
	private String feeCurrency;

	@Column(name = "fee", nullable = false)
	private String fee;
	
	@Column(name = "audience_count", nullable = false)
	private int audienceCount;
	
	public Reservation() {}
 
	public Reservation(User customer, Showing showing, int audienceCount) {
		this.user = customer;
		this.showing = showing;
		this.fee = showing.calculateFee().times(audienceCount);
		this.audienceCount = audienceCount;
	}

	@ManyToOne
	@org.hibernate.annotations.ForeignKey(name = "fk_reservation_parent_id")
	private User user;
	
	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@org.hibernate.annotations.ForeignKey(name = "fk_showing_parent_id")
	private Showing showing;
	
	public void setShowing(Showing showing) {
		this.showing = showing;
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

	public int getAudienceCount() {
		return audienceCount;
	}

	public void setAudienceCount(int audienceCount) {
		this.audienceCount = audienceCount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1; 
		result = prime * result + ((feeAmount == null) ? 0 : feeAmount.hashCode());
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
		Reservation other = (Reservation) obj;
		if (!feeAmount.equals(other.feeAmount))
			return false;
		return true;
	}
}
