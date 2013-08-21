package net.slipp.domain.movie;
  
public class MovieBuilder {
  
	private String title; 
	private Duration runningTime;
	private Money fee;
	 
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public MovieBuilder runningTime(Duration runningTime) {
		this.runningTime = runningTime;
		return this;
	}
	
	public MovieBuilder fee(Money fee) {
		this.fee = fee;
		return this;
	}
	
	public Movie build() {
		return new Movie(title, runningTime, fee);
	}
	
}
