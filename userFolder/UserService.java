package com.group_3.restful_group_3_project;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Annotation to specify that this class is a service and will hold the business logic
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public Optional<User> singleUser(String userID){
        return userRepository.findUserByUserID(userID);
    }
}
