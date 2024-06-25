package com.group_3.restful_group_3_project.services;

import com.group_3.restful_group_3_project.ShoppingCart;
import com.group_3.restful_group_3_project.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public double getSubtotalByUserID(String userID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            ShoppingCart cart = cartOpt.get();
            return cart.getBook().stream()
                        .mapToDouble(book -> book.getPrice())
                        .sum();
        }
        return 0.0;
    }
}