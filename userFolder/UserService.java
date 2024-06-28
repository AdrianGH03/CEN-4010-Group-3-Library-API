package com.group_3.restful_group_3_project.userFolder;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // Annotation to specify that this class is a service and will hold the business logic
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Get single user
    public Optional<User> singleUser(String username){
        return userRepository.findUserByUsername(username);
    }

    //Sign up user using username, password, and email
    public User createUser(User user){
        if(!UserValidation.isValidUsername(user.getUsername())) throw new IllegalStateException("Invalid username");
        if(!UserValidation.isValidPassword(user.getPassword())) throw new IllegalStateException("Invalid password or password length less than 8 characters");
        if(!UserValidation.isValidEmail(user.getEmail())) throw new IllegalStateException("Invalid email format");

        Optional<User> existingUser = userRepository.findUserByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("Username already exists");
        }
        User newUser = new User();

        try {
            if(userRepository.findUserByEmail(user.getEmail()).isPresent()){
                throw new IllegalStateException("Email already exists");
            } else if(userRepository.findUserByUsername(user.getUsername()).isPresent()){
                throw new IllegalStateException("Username already exists");
            } else {
                newUser.setUserID(UUID.randomUUID().toString()); // will show as _id in MongoDB but can still use userID in code and uses UUID to generate a random ID
                newUser.setUsername(user.getUsername());
                newUser.setPassword(user.getPassword());
                newUser.setEmail(user.getEmail());
                newUser.setWishlist(new ArrayList<>()); 
                //User still needs credit card in future...
            }

            return userRepository.save(newUser); 
        } catch (Exception e) {
            throw new IllegalStateException("Error creating user: "+e);
        }
        
        
    }

    //Login user using username and password
    public User loginUser(User user){
        if(!UserValidation.isValidUsername(user.getUsername())) throw new IllegalStateException("Invalid username");
        if(!UserValidation.isValidPassword(user.getPassword())) throw new IllegalStateException("Invalid password or password length less than 8 characters");

        Optional<User> existingUser = userRepository.findUserByUsername(user.getUsername());
        User userPassword = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword()).orElse(null);
        
        if (existingUser.isPresent() && userPassword != null) {
            if (existingUser.get().getPassword().equals(user.getPassword())) {
                return existingUser.get();
            } else {
                throw new IllegalStateException("Incorrect password");
            }
        } else {
            throw new IllegalStateException("User does not exist");
        }
    }

    public User updateUser(String username, User newUser){
        Optional<User> existingUser = userRepository.findUserByUsername(username);
        if(!UserValidation.isValidUsername(username) || !existingUser.isPresent()) throw new IllegalStateException("Invalid username");

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            if(newUser.getPassword() != null){
                if(UserValidation.isValidPassword(newUser.getPassword()) && !newUser.getPassword().equals(user.getPassword())){
                    user.setPassword(newUser.getPassword());
                } else {
                    throw new IllegalStateException("Invalid password or password length less than 8 characters or password is the same as the current password.");
                }
            } 
            if(newUser.getUsername() != null){
                if(!userRepository.findUserByUsername(newUser.getUsername()).isEmpty()){
                    throw new IllegalStateException("Username already exists");
                } else if(UserValidation.isValidUsername(newUser.getUsername()) && !newUser.getUsername().equals(user.getUsername())){
                    user.setUsername(newUser.getUsername());
                } else {
                    throw new IllegalStateException("Invalid username or username is the same as the current username.");
                }
            } 
            
            return userRepository.save(user);
        } else {
            throw new IllegalStateException("User does not exist");
        }
    }
}
