package com.group_3.restful_group_3_project;

import com.group_3.restful_group_3_project.exceptions.CartNotFoundException;
import com.group_3.restful_group_3_project.exceptions.BookNotFoundException;
import com.group_3.restful_group_3_project.services.ShoppingCartService;
import com.group_3.restful_group_3_project.bookFolder.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/subtotal")
    public double getCartSubtotal(@RequestParam String userID) {
        return shoppingCartService.getSubtotalByUserID(userID);
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBookToCart(@RequestParam String userID, @RequestParam String bookID) {
        try {
            shoppingCartService.addBookToCart(userID, bookID);
            return ResponseEntity.ok("Book added to cart successfully");
        } catch (CartNotFoundException | BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/books")
    public List<Book> getBooksInCart(@RequestParam String userID) {
        return shoppingCartService.getBooksInCart(userID);
    }

    @DeleteMapping("/books")
    public ResponseEntity<String> deleteBookFromCart(@RequestParam String userID, @RequestParam String bookID) {
        try {
            shoppingCartService.deleteBookFromCart(userID, bookID);
            return ResponseEntity.ok("Book removed from cart successfully");
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
