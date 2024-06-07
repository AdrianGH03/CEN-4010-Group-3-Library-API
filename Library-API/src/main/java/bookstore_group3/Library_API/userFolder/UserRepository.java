package bookstore_group3.Library_API.userFolder;
import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Annotation to specify that this class is a repository, which connects to the database
public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findUserByUserID(String userID);
}
