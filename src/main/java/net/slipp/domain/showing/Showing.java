package net.slipp.domain.showing;

import java.util.Date;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.slipp.domain.CreatedAndUpdatedDateEntityListener;
import net.slipp.domain.HasCreatedAndUpdatedDate;
import net.slipp.domain.movie.Money;
import net.slipp.domain.movie.Movie;  
import net.slipp.domain.reservation.Reservation;
import net.slipp.domain.user.User;

@Entity
@EntityListeners({ CreatedAndUpdatedDateEntityListener.class })
public class Showing implements HasCreatedAndUpdatedDate {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showingId = 1;
 
	@Column(name = "sequence", nullable = false)
	private String sequence;

	@Column(name = "showing_time", nullable = false)
	private String showingTime;
   
	@ManyToOne(optional=false) 
	@JoinColumn(name="MOVIE_ID")
	private Movie movie;
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Reservation reserve(User customer, int audienceCount){
		return new Reservation(customer, this, audienceCount);
	}
	
	public Money calculateFee(){
		return movie.calculateFee(this);
	}
	 
	@OneToOne
	@org.hibernate.annotations.ForeignKey(name = "fk_showing_parent_id")
	public Showing parent;
	 
	
	public Showing() {
	}

	public Showing(Movie movie, String sequence, String showingTime) {
		this.movie = movie;
		this.sequence = sequence;
		this.sequence = sequence;
	}
	
	public int getShowingId() {
		return showingId;
	}

	public void setShowingId(int showingId) {
		this.showingId = showingId;
	}
 
	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getShowingTime() {
		return showingTime;
	}

	public void setShowingTime(String showingTime) {
		this.showingTime = showingTime;
	}

	public Movie getMovie() {
		return movie;
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
		result = prime * result + ((sequence == null) ? 0 : sequence.hashCode()); 
		result = prime * result + ((showingTime == null) ? 0 : showingTime.hashCode()); 
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
		Showing other = (Showing) obj;
		if (!sequence.equals(other.sequence))
			return false;
		if (!showingTime.equals(other.showingTime))
			return false; 
		return true;
	}

	@Override
	public String toString() {
		return "Showing [showingId=" + showingId + ", movie=" + movie + ", sequence=" + sequence + ", showingTime=" + showingTime + "]";
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

	public Money getFixedFee() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPlayngInterval() {
		// TODO Auto-generated method stub
		return 95;
	}

	public boolean isPlayingOn(String dayofweek) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSequence(String sequence2) {
		// TODO Auto-generated method stub
		return false;
	}
}
