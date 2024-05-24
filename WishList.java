package com.group_3.restful_group_3_project;

public class WishList {

  	String userId;
	String wishListName;
	List<Book>book;
	
	
	public WishList() {
		super();
	}
	
	public WishList(String userId, String wishListName, List<Book> book) {
		super();
		this.userId = userId;
		this.wishListName = wishListName;
		this.book = book;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getWishListName() {
		return wishListName;
	}
	
	public void setWishListName(String wishListName) {
		this.wishListName = wishListName;
	}
	
	public List<Book> getBook() {
		return book;
	}
	
	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	
	
	


}
