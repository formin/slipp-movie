package net.slipp.domain.discount;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.slipp.domain.CreatedAndUpdatedDateEntityListener;
import net.slipp.domain.HasCreatedAndUpdatedDate; 
import net.slipp.domain.movie.Movie;

@Entity
@EntityListeners({ CreatedAndUpdatedDateEntityListener.class })
public class Discount implements HasCreatedAndUpdatedDate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int discountId = 1;
 
	@ManyToOne
	@org.hibernate.annotations.ForeignKey(name = "fk_discount_parent_id")
	private Movie movie;
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
 
	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	  
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false)
	private Date updatedDate;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1; 
		result = prime * result + ((movie == null) ? 0 : movie.hashCode()); 
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
		Discount other = (Discount) obj;
		if (!movie.equals(other.movie))
			return false; 
		return true;
	}

	@Override
	public String toString() {
		return "Showing [discountId=" + discountId + ", movie=" + movie + "]";
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
