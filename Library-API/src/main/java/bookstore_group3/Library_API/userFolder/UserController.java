package bookstore_group3.Library_API.userFolder;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Annotation to specify that this class is a controller and will hold the endpoints (CRUD operations)
@RequestMapping("/authentication/users") // Endpoint to access the user collection in MongoDB (i.e. http://localhost:8080/authentication/users)
public class UserController {
    @Autowired
    private UserService userService;

    // Endpoint to get all users (i.e. http://localhost:8080/authentication/users)
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
    }

    // Endpoint to get a single user by their userID (i.e. http://localhost:8080/authentication/users/123456)
    @GetMapping("/{userID}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String userID){
        return new ResponseEntity<Optional<User>>(userService.singleUser(userID), HttpStatus.OK);
    }
}
