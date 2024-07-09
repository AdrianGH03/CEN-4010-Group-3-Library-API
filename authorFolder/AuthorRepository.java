package com.group_3.restful_group_3_project;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
}
