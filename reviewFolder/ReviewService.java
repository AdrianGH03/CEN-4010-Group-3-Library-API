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
    	
    	Book potentialBook = bookRepository.findByIsbn(isbn);
    	if(potentialBook != null) {
    		rating.setRatedOn(LocalDate.now());
    		potentialBook.addRating(rating);
    	    bookRepository.save(potentialBook);
    	}else {
    		throw new NoSuchElementException("Book not Found");
    	}
    }
    
    public void leaveCommentService(String isbn, Comment comment) {

    	Book potentialBook = bookRepository.findByIsbn(isbn);
    	if(potentialBook != null) {
    		comment.setRatedOn(LocalDate.now());
    		potentialBook.addComment(comment);
    	    bookRepository.save(potentialBook);
    	}else {
    		throw new NoSuchElementException("Book not Found");
    	}
    }
    
    public List<Comment> retrieveCommentsService(String isbn){
    	Book potentialBook = bookRepository.findByIsbn(isbn);
    	if (potentialBook != null){
    		List<Comment> bookComments = potentialBook.getComments();
    		if (!bookComments.isEmpty()) {
    			return bookComments;
    		}
    		return new ArrayList<>();
    	}
        throw new NoSuchElementException("Book not Found");
    }

    

    
}
