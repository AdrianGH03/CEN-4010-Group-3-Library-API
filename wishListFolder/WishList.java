package com.group_3.restful_group_3_project.wishListFolder;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
@NoArgsConstructor // Lombok annotation to create a no args constructor
@AllArgsConstructor // Lombok annotation to create a all args constructor

public class WishList {
private String userID;
private String wishListName;
private List<String> books = new ArrayList<>();

public WishList(String userID, String wishListName) {
    super();
    this.userID = userID;
    this.wishListName = wishListName;
}

    public void addBook(String title) {
        if (title != null && !title.isEmpty()) {
            this.books.add(title);}
             
    }else {
            throw new IllegalArgumentException("Title cannot be null or empty");
    }
}
