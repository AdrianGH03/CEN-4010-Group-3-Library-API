package bookstore_group3.Library_API.bookFolder;

import java.util.List;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import bookstore_group3.Library_API.reviewFolder.Rating;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id   
	private String id;
    private String ISBN; 
    private String title;
    private String genre;
    private String publisher;
    private double price;
    private int copiesSold;
    private List<Rating> ratings;

    public void addRating(Rating rating) {
        ratings.add(rating);
    }
}
