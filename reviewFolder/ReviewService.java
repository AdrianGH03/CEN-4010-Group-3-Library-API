package com.group_3.restful_group_3_project.reviewFolder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.bookFolder.BookRepository;

@Service
public class ReviewService {
    private final BookRepository bookRepository;
    

    @Autowired
    public ReviewService(BookRepository bookRepository) {
        this.bookRepository = bookRepository; 
    }
    
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);       
    }
    
    
    public void rateBookService(String isbn, Rating rating) {
	Book potentialBook = getIfBookExists(isbn); 
	rating.setRatedOn(LocalDate.now()); //set the rateOn field of the rating object to the system date
	potentialBook.addRating(rating); //add a new rating to the rating field of the Book
	bookRepository.save(potentialBook);
    }
    
    
    public void leaveCommentService(String isbn, Comment comment) {
    	Book potentialBook = getIfBookExists(isbn); 
    	comment.setRatedOn(LocalDate.now()); //set the rateOn field of the comment object to the system date
    	potentialBook.addComment(comment); //add a new rating to the comment field of the Book
    	bookRepository.save(potentialBook);
    }
    
        
    public List<Comment> retrieveCommentsService(String isbn){
    	List<Comment> bookComments = getIfBookExists(isbn).getComments();//gets a book comments field 
    	if (!bookComments.isEmpty()) { //if comments field is not empty
    		return bookComments; //return all the books comments
    	}
    	return new ArrayList<>();//if no comments exist return an empty list
    }
    
    
    public double retrieveRatingsService(String isbn) {
    	List<Rating> ratings = getIfBookExists(isbn).getRatings(); //gets a bok ratings field
    	double sum = 0;
    	if (!ratings.isEmpty()) { //if ratings field is not empty
	    	for (Rating rating: ratings) {
	    		sum += rating.getStarRating(); //sum the ratings
	    	}
	    	return sum/ratings.size(); // return the average
	    }
    	return 0;// if ratings field is empty return 0
    }
    
    
    public Book getIfBookExists(String isbn) {
    	Book potentialBook = bookRepository.findByIsbn(isbn);//check if there exists a book with a matching isbn in the database
    	if (potentialBook == null){
    		throw new NoSuchElementException("Book not Found");	//if no books match the isbn throw an exception
    	}
    	return potentialBook; //return a book if present in the database
    }
    
 
    
}
