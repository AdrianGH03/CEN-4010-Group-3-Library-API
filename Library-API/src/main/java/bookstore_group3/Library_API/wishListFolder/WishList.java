package bookstore_group3.Library_API.wishListFolder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import org.springframework.data.annotation.Id;
import bookstore_group3.Library_API.bookFolder.Book;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishList {
    @Id
    private String userID;
    private String wishListName;
    private List<Book> book;
}