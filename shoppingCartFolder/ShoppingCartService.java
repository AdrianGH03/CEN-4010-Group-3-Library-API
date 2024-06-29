package com.group_3.restful_group_3_project.services;

import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.repositories.BookRepository;
import com.group_3.restful_group_3_project.shoppingcart.ShoppingCart;
import com.group_3.restful_group_3_project.shoppingcart.ShoppingCartRepository;
import com.group_3.restful_group_3_project.exceptions.CartNotFoundException;
import com.group_3.restful_group_3_project.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private BookRepository bookRepository;

    public double getSubtotalByUserID(String userID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            ShoppingCart cart = cartOpt.get();
            return cart.getBook().stream()
                        .mapToDouble(Book::getPrice)
                        .sum();
        }
        return 0.0;
    }

    public void addBookToCart(String userID, String bookID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        Optional<Book> bookOpt = bookRepository.findById(bookID);
        
        if (!cartOpt.isPresent()) {
            throw new CartNotFoundException("Shopping cart not found for user ID: " + userID);
        }
        
        if (!bookOpt.isPresent()) {
            throw new BookNotFoundException("Book not found with ID: " + bookID);
        }

        ShoppingCart cart = cartOpt.get();
        Book book = bookOpt.get();
        cart.getBook().add(book);
        shoppingCartRepository.save(cart);
    }
}
