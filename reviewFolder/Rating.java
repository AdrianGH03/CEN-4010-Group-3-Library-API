package com.group_3.restful_group_3_project.reviewFolder;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
@NoArgsConstructor // Lombok annotation to create a no args constructor
@AllArgsConstructor // Lombok annotation to create a all args constructor
@EqualsAndHashCode(callSuper = true)

public class Rating extends Review {
	
	@Min(1) 
	@Max(5)
	private int starRating;
		
}
