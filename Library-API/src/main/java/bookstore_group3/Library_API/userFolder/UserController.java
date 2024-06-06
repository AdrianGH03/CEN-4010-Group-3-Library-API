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

@RestController
@RequestMapping("/authentication/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userID}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String userID){
        return new ResponseEntity<Optional<User>>(userService.singleUser(userID), HttpStatus.OK);
    }
}
