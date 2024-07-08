package com.group_3.restful_group_3_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;
    
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}
