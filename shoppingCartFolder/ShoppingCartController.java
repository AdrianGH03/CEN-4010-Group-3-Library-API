package com.group_3.restful_group_3_project;

import com.group_3.restful_group_3_project.exceptions.CartNotFoundException;
import com.group_3.restful_group_3_project.exceptions.BookNotFoundException;
import com.group_3.restful_group_3_project.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

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
    public ResponseEntity<String> addBookToCart(@RequestParam String userID, @RequestParam String bookID) {
        try {
            shoppingCartService.addBookToCart(userID, bookID);
            return ResponseEntity.ok("Book added to cart successfully");
        } catch (CartNotFoundException | BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<String> handleCartNotFoundException(CartNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
