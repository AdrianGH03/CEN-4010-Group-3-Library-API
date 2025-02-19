package com.group_3.restful_group_3_project.bookFolder;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.group_3.restful_group_3_project.reviewFolder.Rating;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
@NoArgsConstructor // Lombok annotation to create a no args constructor
@AllArgsConstructor // Lombok annotation to create a all args constructor
@Document(collection = "books") // Annotation to specify the collection name in MongoDB
public class Book {
    @Id  // Annotation to specify the primary key of the document
    private String isbn; 

    private String title;
    private String genre;
    private String publisher;
    private double price;
    private int copiesSold;
    private List<Comment> comments;
    private List<Rating> ratings;
    private int yearPublished;
    private String author;
    private String description;


    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void addComment(Comment comment) {
		this.comments.add(comment);	
	}
}
