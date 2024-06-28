package com.group_3.restful_group_3_project.userFolder;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController // Annotation to specify that this class is a controller and will hold the endpoints (CRUD operations)
@RequestMapping("/authentication") // Endpoint to access authentication for users in MongoDB (i.e. http://localhost:8080/authentication)
public class UserController {
    @Autowired
    private UserService userService;

    //Signup
    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

    //Login
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.loginUser(user), HttpStatus.OK);
    }

    //Get user by username
    @GetMapping("/user/{username}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String username){
        return new ResponseEntity<Optional<User>>(userService.singleUser(username), HttpStatus.OK);
    }

    @PutMapping("/user/{username}")
    public ResponseEntity<String> updateUser(@PathVariable String username, @RequestBody User newUser){
        userService.updateUser(username, newUser);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }




}
