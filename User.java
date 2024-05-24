package com.group_3.restful_group_3_project;

public class User {
  String username;
	String password;
	String userID;
	CreditCard creditCard;
	
	public User() {}
		
	
	
	public User(String username, String password, String userID, CreditCard creditCard) {
		super();
		this.username = username;
		this.password = password;
		this.userID = userID;
		this.creditCard = creditCard;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	
	

}
