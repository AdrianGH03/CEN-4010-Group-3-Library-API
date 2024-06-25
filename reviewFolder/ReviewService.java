package com.group_3.restful_group_3_project.reviewFolder;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.bookFolder.BookRepository;

@Service // Annotation to specify that this class is a service and will hold the business logic
public class ReviewService {

    private final BookRepository bookRepository;
	
    @Autowired
    public ReviewService(BookRepository bookRepository) { //constructor injection
        this.bookRepository = bookRepository; 
    }
	
    
    // Method to rate a book and save the rating to the database
    public void rateBookService(String isbn, Rating rating) {
    	
    	Book potentialBook = bookRepository.findByIsbn(isbn);  //uses find by isbn to check whether there is a book in the database that matches the isbn
    	if(potentialBook != null) {
    		rating.setRatedOn(LocalDate.now()); //sets the ratedOn field of the rating as the date from the users system clock, user will pass the star rating and userID in the request body
		potentialBook.addRating(rating);  //use the book class's addRating feature
    	        bookRepository.save(potentialBook); //save the updated book to the repository
	} else {
    		throw new NoSuchElementException("No books match this ISBN");
    	}
    }

   public void leaveCommentService(String isbn, Comment comment) {

    	Book potentialBook = bookRepository.findByIsbn(isbn); //uses find by isbn to check whether there is a book in the database that matches the isbn
    	if(potentialBook != null) {
    		comment.setRatedOn(LocalDate.now());  //sets the ratedOn field of the comment as the date from the users system clock, user will pass the star rating and userID in the request body
    		potentialBook.addComment(comment); //use the book class's addComment feature
    	        bookRepository.save(potentialBook); //save the updated book to the repository
    	}else {
    	        throw new NoSuchElementException("No books match this ISBN");
    	}
    }
      
}
