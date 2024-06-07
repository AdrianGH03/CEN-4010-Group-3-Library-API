package bookstore_group3.Library_API.reviewFolder;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookstore_group3.Library_API.bookFolder.Book;
import bookstore_group3.Library_API.bookFolder.BookRepository;

@Service // Annotation to specify that this class is a service and will hold the business logic
public class ReviewService {
	@Autowired
    private BookRepository bookRepository;
	
    
    // Method to rate a book and save the rating to the database
    public void rateBookService(String ISBN, Rating rating) {
    	
    	Book potentialBook = bookRepository.findByISBN(ISBN);
    	if(potentialBook != null) {
    		rating.setRatedOn(LocalDate.now());
    		potentialBook.addRating(rating);
    	    bookRepository.save(potentialBook);
    	} else {
    		throw new NoSuchElementException("No books match this ISBN");
    	}
    }
      
}
