package shoppingCartFolder;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.group_3.restful_group_3_project.bookFolder.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Document(collection = "shopping_carts")
public class ShoppingCart {
    @Id
    private String userID;
    private double subTot;
    private List<Book> books;

    public ShoppingCart(String userID, double subTot, List<Book> books) {
        this.userID = userID;
        this.subTot = subTot;
        this.books = books;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getSubTot() {
        return subTot;
    }

    public void setSubTot(double subTot) {
        this.subTot = subTot;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addItem(Book book) {
        books.add(book);
    }
}
