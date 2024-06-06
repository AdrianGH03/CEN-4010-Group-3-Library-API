package bookstore_group3.Library_API.reviewFolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    
    @Autowired
    private ReviewService bookService;
        
    @PostMapping(path="books/{ISBN}/rate")
    public void rateBook(@PathVariable String ISBN, @RequestBody Rating rating) {
        bookService.rateBookService(ISBN,rating);
    }
}