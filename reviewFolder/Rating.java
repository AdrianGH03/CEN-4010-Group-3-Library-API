package com.group_3.restful_group_3_project;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
@NoArgsConstructor // Lombok annotation to create a no args constructor
@AllArgsConstructor // Lombok annotation to create a all args constructor
public class Rating {
    @Id // Annotation to specify the primary key of the document
    private String _id;
    
    private LocalDate ratedOn;
    private int starRating;
}