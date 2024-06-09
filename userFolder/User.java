package com.group_3.restful_group_3_project.userFolder;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
@NoArgsConstructor // Lombok annotation to create a no args constructor
@AllArgsConstructor // Lombok annotation to create a all args constructor
@Document(collection = "users") // Annotation to specify the collection name in MongoDB
public class User {
    @Id
    private String _id;
    
    private String userID;
    private String name;
    private String password;
    private String email;
    private ArrayList<String> wishlist;
    private CreditCard creditCard;
}
