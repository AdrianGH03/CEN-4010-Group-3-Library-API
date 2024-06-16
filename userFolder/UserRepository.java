package com.group_3.restful_group_3_project.userFolder;
import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Annotation to specify that this class is a repository, which connects to the database
public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUsernameAndPassword(String username, String password);
    
}
