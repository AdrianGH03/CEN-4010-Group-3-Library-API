package com.group_3.restful_group_3_project.reviewFolder;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.group_3.restful_group_3_project.bookFolder.Book;

import jakarta.validation.Valid;

@RestController
public class ReviewController {
	
	
private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
				
	@GetMapping(path="books/{isbn}")
	public Book retrieveBook(@PathVariable String isbn) {
		return reviewService.findByIsbn(isbn);
	}

	@PostMapping(path="books/{isbn}/rate")
	public void rateBook(@PathVariable String isbn,@Valid @RequestBody Rating rating) {
		reviewService.rateBookService(isbn,rating);
	}
	
	@PostMapping(path="books/{isbn}/comment")
	public void leaveComment(@PathVariable String isbn,@RequestBody Comment comment) {
		reviewService.leaveCommentService(isbn,comment);
	}
	
	@GetMapping(path="books/{isbn}/getComments")
	public ResponseEntity<?> getAllComments(@PathVariable String isbn){
		List<Comment> comments = reviewService.retrieveCommentsService(isbn);
		
		if (!comments.isEmpty()) {
			return ResponseEntity.ok(comments);
		}
		 return ResponseEntity.ok("This book has no comments");
	 }
	
	
	@GetMapping(path="books/{isbn}/aveRating")
	public ResponseEntity<?> getAverage(@PathVariable String isbn){
		double averageRating = reviewService.retrieveRatingsService(isbn);
		if(averageRating > 0) {
			return ResponseEntity.ok(averageRating);
		}
		return ResponseEntity.ok("This book has not been rated");
	}
	

	
}
