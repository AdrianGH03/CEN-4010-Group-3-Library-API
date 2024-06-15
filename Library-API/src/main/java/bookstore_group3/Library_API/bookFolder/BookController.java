<<<<<<< HEAD:Library-API/src/main/java/bookstore_group3/Library_API/bookFolder/BookController.java
package bookstore_group3.Library_API.bookFolder;
=======
package com.group_3.restful_group_3_project.bookFolder;
>>>>>>> d3f213d03255f039b10a712938c3047f38ee9a22:bookFolder/BookController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // Annotation to specify that this class is a controller and will hold the endpoints (CRUD operations)
public class BookController {

	@Autowired 
	private BookService bookService;

}
