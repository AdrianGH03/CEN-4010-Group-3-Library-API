package com.group_3.restful_group_3_project.shoppingCartFolder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.group_3.restful_group_3_project.bookFolder.Book;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shoppingCarts")
public class ShoppingCart {

    @Id
    private String id;
    private String userID;
    private double subTot;
    private List<Book> books;

    public double calculateSubtotal() {
        if (books != null && !books.isEmpty()) {
            subTot = books.stream()
                          .mapToDouble(Book::getPrice)
                          .sum();
        } else {
            subTot = 0.0;
        }
        return subTot;
    }

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            calculateSubtotal();
        }
    }

    public void removeBook(String bookID) {
        if (books != null && !books.isEmpty()) {
            books.removeIf(book -> book.getIsbn().equals(bookID));
            calculateSubtotal();
        }
    }
}
