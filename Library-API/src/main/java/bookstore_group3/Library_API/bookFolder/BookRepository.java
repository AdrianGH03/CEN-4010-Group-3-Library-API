<<<<<<< HEAD:Library-API/src/main/java/bookstore_group3/Library_API/bookFolder/BookRepository.java
package bookstore_group3.Library_API.bookFolder;
=======
package com.group_3.restful_group_3_project.bookFolder;
>>>>>>> d3f213d03255f039b10a712938c3047f38ee9a22:bookFolder/BookRepository.java


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Annotation to specify that this class is a repository, which connects to the database
public interface BookRepository extends MongoRepository<Book, String> {
	 Book findByISBN(String ISBN);
}
