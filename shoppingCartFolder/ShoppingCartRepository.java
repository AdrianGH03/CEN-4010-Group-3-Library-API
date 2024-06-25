package com.group_3.restful_group_3_project.shoppingcart;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
    Optional<ShoppingCart> findByUserID(String userID);
}