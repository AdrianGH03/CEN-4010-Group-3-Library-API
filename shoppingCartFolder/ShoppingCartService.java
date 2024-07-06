package com.group_3.restful_group_3_project.services;

import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.bookFolder.BookRepository;
import com.group_3.restful_group_3_project.exceptions.BookNotFoundException;
import com.group_3.restful_group_3_project.exceptions.CartNotFoundException;
import com.group_3.restful_group_3_project.shoppingCartFolder.ShoppingCart;
import com.group_3.restful_group_3_project.shoppingcart.ShoppingCartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
            return cart.calculateSubtotal();
        }
        throw new CartNotFoundException("Cart not found for user ID: " + userID);
    }

    public void addBookToCart(String userID, String bookID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            ShoppingCart cart = cartOpt.get();
            Book book = findBookByID(bookID);
            cart.addBook(book);
            shoppingCartRepository.save(cart);
        } else {
            throw new CartNotFoundException("Cart not found for user ID: " + userID);
        }
    }

    public List<Book> getBooksInCart(String userID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            ShoppingCart cart = cartOpt.get();
            return cart.getBooks();
        }
        throw new CartNotFoundException("Cart not found for user ID: " + userID);
    }

    public void deleteBookFromCart(String userID, String bookID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            ShoppingCart cart = cartOpt.get();
            cart.removeBook(bookID);
            shoppingCartRepository.save(cart);
        } else {
            throw new CartNotFoundException("Cart not found for user ID: " + userID);
        }
    }

    private Book findBookByID(String bookID) {
        return bookRepository.findById(bookID)
                .orElseThrow(() -> new BookNotFoundException("Book not found for ID: " + bookID));
    }
}
