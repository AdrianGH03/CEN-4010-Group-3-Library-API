package com.group_3.restful_group_3_project;

public class Rating {
  String userID;
	int starRating;
	String comment;
	String IBSN;
	
	public Rating() {}
	
	public Rating(String userID, int starRating, String comment, String iBSN) {
		super();
		this.userID = userID;
		this.comment = comment;
		this.starRating = starRating;
		IBSN = iBSN;
	}
	
	


}
