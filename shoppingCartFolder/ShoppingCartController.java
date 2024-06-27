package com.group_3.restful_group_3_project;

import com.group_3.restful_group_3_project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/cart/subtotal")
    public double getCartSubtotal(@RequestParam String userID) {
        return shoppingCartService.getSubtotalByUserID(userID);
    }

    @PostMapping("/cart/addBook")
    public void addBookToCart(@RequestParam String userID, @RequestParam String bookID) {
        shoppingCartService.addBookToCart(userID, bookID);
    }
}
