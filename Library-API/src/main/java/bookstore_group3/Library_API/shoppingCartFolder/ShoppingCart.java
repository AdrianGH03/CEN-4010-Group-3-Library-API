package bookstore_group3.Library_API.shoppingCartFolder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import bookstore_group3.Library_API.bookFolder.Book;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private String _id;
    private double subTot;
    private List<Book> book;
}