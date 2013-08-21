package net.slipp.domain.movie;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Duration {

	@Column(name="RUNNING_TIME", nullable=false)
	private long quantity;

	public Duration() {
	}
	
	Duration(long quantity) {
		this.quantity = quantity; 
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
}
