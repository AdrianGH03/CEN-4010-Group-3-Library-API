package com.group_3.restful_group_3_project.shoppingCartFolder;

import com.group_3.restful_group_3_project.bookFolder.Book;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

private final ShoppingCartService shoppingCartService;

@Autowired
public ShoppingCartController(ShoppingCartService shoppingCartService) {
this.shoppingCartService = shoppingCartService;
}

@GetMapping("/subtotal/{userID}")
public double getCartSubtotal(@PathVariable String userID) {
return shoppingCartService.getSubtotalByUserID(userID);
}

@PostMapping("/addBook/{userID}/{isbn}")
public ResponseEntity<String> addBookToCart(@PathVariable String userID, @PathVariable String isbn) {
try {
shoppingCartService.addBookToCart(userID, isbn);
return ResponseEntity.ok("Book added to cart successfully");
} catch (RuntimeException e) {
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
}
}

@GetMapping("/books/{userID}")
public List<Book> getBooksInCart(@PathVariable String userID) {
return shoppingCartService.getBooksInCart(userID);
}

@DeleteMapping("/removeBook/{userID}/{isbn}")
public ResponseEntity<String> removeBookFromCart(@PathVariable String userID, @PathVariable String isbn) {
try {
    shoppingCartService.removeBookFromCart(userID, isbn);
    return ResponseEntity.ok("Book removed from cart successfully");
} catch (RuntimeException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
}
}


}
