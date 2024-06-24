package com.group_3.restful_group_3_project.bookFolder;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }
}
