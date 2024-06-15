<<<<<<< HEAD:Library-API/src/main/java/bookstore_group3/Library_API/bookFolder/BookService.java
package bookstore_group3.Library_API.bookFolder;
=======
package com.group_3.restful_group_3_project.bookFolder;
>>>>>>> d3f213d03255f039b10a712938c3047f38ee9a22:bookFolder/BookService.java

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Annotation to specify that this class is a service and will hold the business logic
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    


          
}
