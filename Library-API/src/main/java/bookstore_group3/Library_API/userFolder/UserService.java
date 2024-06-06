package bookstore_group3.Library_API.userFolder;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public Optional<User> singleUser(String userID){
        return userRepository.findUserBy_id(userID);
    }
}
