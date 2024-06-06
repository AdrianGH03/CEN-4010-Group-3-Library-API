package bookstore_group3.Library_API.userFolder;
import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findUserByUserID(String userID);
}
