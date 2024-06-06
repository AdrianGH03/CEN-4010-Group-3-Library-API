package bookstore_group3.Library_API.userFolder;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
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
