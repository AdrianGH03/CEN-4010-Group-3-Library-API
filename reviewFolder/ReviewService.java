package com.group_3.restful_group_3_project.reviewFolder;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.bookFolder.BookRepository;

@Service // Annotation to specify that this class is a service and will hold the business logic
public class ReviewService {
	@Autowired
    private BookRepository bookRepository;
	
    
    // Method to rate a book and save the rating to the database
    public void rateBookService(String isbn, Rating rating) {
    	
    	Book potentialBook = bookRepository.findByIsbn(isbn);
    	if(potentialBook != null) {
    		rating.setRatedOn(LocalDate.now());
			rating.setStarRating(rating.getStarRating());
    		potentialBook.addRating(rating);
    	    bookRepository.save(potentialBook);
		} else {
    		throw new NoSuchElementException("No books match this ISBN");
    	}
    }
      
}
