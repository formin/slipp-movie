package net.slipp.domain.movie;
 
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy; 
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.collect.Lists;
 
import net.slipp.domain.HasCreatedAndUpdatedDate; 
import net.slipp.domain.discount.Discount;
import net.slipp.domain.showing.Showing;
 
@Entity
@Table(name="MOVIE")
public class Movie implements HasCreatedAndUpdatedDate {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId = 1;

	@Column(name = "title", nullable = false)
	private String title;
	
	private Duration runningTime;
	private Money fee;
	 
	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
	@OrderBy("showingId DESC")
	private List<Showing> showings;
 
	@OneToOne(cascade=CascadeType.ALL, optional=true, fetch=FetchType.LAZY)
	private Discount discounts;
	
	public Movie() {}

	public Movie(String title, Duration runningTime, Money fee) { 
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee; 
	}

	private static final Discount discountStrategy = null;
	
	public Money calculateFee(Showing showing){
		return discountStrategy.calculateFee(showing);
	}
	
	public void addShowing(Showing showing) {
		if (showings == null) {
			showings = Lists.newArrayList();
		}
		showings.add(showing); 
		showing.setMovie(this);
	}

	public List<Showing> getShowing() {
		return showings;
	}

	/*
	public void addDiscount(Discount discount) {
		if (discounts == null) {
			discounts = Lists.newArrayList();
		}
		discounts.add(discount); 
		discount.setMovie(this);
	}

	public List<Discount> getDiscount() {
		return discounts;
	}
	*/
	
	public int getShowingId() {
		return movieId;
	}

	public void setShowingId(int movie_Id) {
		this.movieId = movie_Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Duration getRunning_Time() {
		return runningTime;
	}

	public void setRunning_Time(Duration runningTime) {
		this.runningTime = runningTime;
	}

	public Money getFee() {
		return fee;
	}

	public void setFee(Money fee) {
		this.fee = fee;
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
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((runningTime == null) ? 0 : runningTime.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode()); 
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
		Movie other = (Movie) obj;
		if (!title.equals(other.title))
			return false;
		if (!runningTime.equals(other.runningTime))
			return false;
		if (!fee.equals(other.fee))
			return false; 
		return true;
	}

	@Override
	public String toString() {
		return "Showing [movieId=" + movieId + ", title=" + title + ", runningTime=" + runningTime + ", fee=" + fee + "]";
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
