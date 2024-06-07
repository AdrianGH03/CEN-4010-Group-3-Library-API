package bookstore_group3.Library_API.bookFolder;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Annotation to specify that this class is a repository, which connects to the database
public interface BookRepository extends MongoRepository<Book, String> {
	 Book findByISBN(String ISBN);
}
