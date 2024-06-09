package com.group_3.restful_group_3_project;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Annotation to specify that this class is a service and will hold the business logic
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    


          
}
