package com.group_3.restful_group_3_project.bookFolder;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Annotation to specify that this class is a repository, which connects to the database
public interface BookRepository extends MongoRepository<Book, String> {
	 Book findByIsbn(String isbn);
         List<Book> findByPublisher(String publisher);
}
