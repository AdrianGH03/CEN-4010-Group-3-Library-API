package com.group_3.restful_group_3_project;
import java.time.LocalDate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class Rating {
	private LocalDate ratedOn;
	private String userID;
	
	@Min(1) 
	@Max(5)
	private int starRating;
	
	public Rating() {}
	
	public Rating(LocalDate ratedOn, String userID, int starRating) {
		super();
		this.userID = userID;
		this.starRating = starRating;
		this.ratedOn = ratedOn;
	}

	public String getUserID() {
		return userID;
	}
	
	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public LocalDate getRatedOn() {
		return ratedOn;
	}
    
	public void setRatedOn(LocalDate ratedOn) {
		this.ratedOn = ratedOn;
	}
	
}
