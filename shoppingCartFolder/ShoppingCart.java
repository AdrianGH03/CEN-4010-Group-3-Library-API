package com.group_3.restful_group_3_project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.data.annotation.Id;

import bookstore_group3.Library_API.bookFolder.Book;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
@NoArgsConstructor // Lombok annotation to create a no args constructor
@AllArgsConstructor // Lombok annotation to create a all args constructor

public class ShoppingCart {
    @Id  // Annotation to specify the primary key of the document
    private String id;
    private double subTot;
    private List<Book> book;
}