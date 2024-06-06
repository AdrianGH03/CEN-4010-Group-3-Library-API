package bookstore_group3.Library_API.bookFolder;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
	 Book findByISBN(String ISBN);
}
