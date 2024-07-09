package com.group_3.restful_group_3_project.bookFolder;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {

    @Id
    private String isbn;  // Fixed typo from IBSN to isbn
    private String title;
    private String genre;
    private String publisher;
    private double price;
    private int copiesSold;
    private List<Rating> rating; //Added list for comments
    private List<Comment> comments; // Added list for comments
    private int yearPublished;
    private String author;
    private String description;

    public Book() {}

    // Getters and Setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", genre=" + genre + ", publisher=" + publisher + ", price=" 
                + price + ", copiesSold=" + copiesSold + ", yearPublished=" + yearPublished + ", author=" + author 
                + ", description=" + description + "]";
    }

  // Add a method to calculate the average rating
    public double calculateAverageRating() {
        if (ratings == null || ratings.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getStarRating();
        }
        return sum / ratings.size();
    }

    // Add a method to add a rating
    public void addRating(Rating rating) {
        if (this.ratings != null) {
            this.ratings.add(rating);
        }
    }
    // Method to add a rating
    public void addRating(Rating rating) {
        if (this.ratings != null) {
            this.ratings.add(rating);
        }
    }

    // Method to add a comment
    public void addComment(Comment comment) {
        if (this.comments != null) {
            this.comments.add(comment);
        }
    }
}
