package com.group_3.restful_group_3_project;

public class Book {
  @Id
	private String id;
	private String title;
	private String genre;
	private String publisher;
	private double price;
	private int copiesSold;
	private String IBSN; 
	private List<Rating> ratings;
	
	public Book() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCopiesSold() {
		return copiesSold;
	}

	public void setCopiesSold(int copiesSold) {
		this.copiesSold = copiesSold;
	}

	public String getIBSN() {
		return IBSN;
	}

	public void setIBSN(String iBSN) {
		IBSN = iBSN;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", genre=" + genre + ", publisher=" + publisher + ", price="
				+ price + ", copiesSold=" + copiesSold + ", IBSN=" + IBSN + "]";
	}

}
