package com.group_3.restful_group_3_project.reviewFolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // Annotation to specify that this class is a controller and will hold the endpoints (CRUD operations)
public class ReviewController {

    private ReviewService bookService;
    
    public ReviewController(ReviewService bookService) {  //constructor injection
		this.bookService = bookService;
	}
        
    @PostMapping(path="books/{isbn}/rate") // Endpoint to rate a book (i.e. http://localhost:8080/books/1234567890123/rate)
   public void rateBook(@PathVariable String isbn,@Valid @RequestBody Rating rating) {
		bookService.rateBookService(isbn,rating);
	}

    @PostMapping(path="books/{isbn}/comment") // Endpoint to rate a book (i.e. http://localhost:8080/books/1234567890123/comment)
	public void leaveComment(@PathVariable String isbn,@RequestBody Comment comment) {
		bookService.leaveCommentService(isbn,comment);
	
    
}
