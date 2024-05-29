package com.group_3.restful_group_3_project;

import java.util.List;

public class ShoppingCart {
    String userID;
    double subTot;
    List<Book> book;
    
    public ShoppingCart() {
		super();
	}
    
	public ShoppingCart(String userID, double subTot, List<Book> book) {
		super();
		this.userID = userID;
		this.subTot = subTot;
		this.book = book;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public double getSubTot() {
		return subTot;
	}
	public void setSubTot(double subTot) {
		this.subTot = subTot;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
    
    
}
