package com.group_3.restful_group_3_project.shoppingCartFolder;
import com.group_3.restful_group_3_project.bookFolder.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")


public class ShoppingCart {
String userID;
double subTot;
List<Book> bookList = new ArrayList<>();

}
