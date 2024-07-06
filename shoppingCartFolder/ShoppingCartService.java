package com.group_3.restful_group_3_project.services;

import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.exceptions.CartNotFoundException;
import com.group_3.restful_group_3_project.exceptions.BookNotFoundException;
import com.group_3.restful_group_3_project.shoppingCartFolder.ShoppingCart;
import com.group_3.restful_group_3_project.shoppingCartFolder.ShoppingCartRepository;
import com.group_3.restful_group_3_project.bookFolder.BookRepository;

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
        } else {
            throw new CartNotFoundException("Cart not found for user ID: " + userID);
        }
    }

    public void addBookToCart(String userID, String bookID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (!cartOpt.isPresent()) {
            throw new CartNotFoundException("Cart not found for user ID: " + userID);
        }

        Book book = findBookByID(bookID);
        ShoppingCart cart = cartOpt.get();
        cart.addBook(book);
        shoppingCartRepository.save(cart);
    }

    public List<Book> getBooksInCart(String userID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            return cartOpt.get().getBooks();
        } else {
            throw new CartNotFoundException("Cart not found for user ID: " + userID);
        }
    }

    public void deleteBookFromCart(String userID, String bookID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (!cartOpt.isPresent()) {
            throw new CartNotFoundException("Cart not found for user ID: " + userID);
        }

        ShoppingCart cart = cartOpt.get();
        cart.removeBook(bookID);
        shoppingCartRepository.save(cart);
    }

    private Book findBookByID(String bookID) {
        return bookRepository.findById(bookID).orElseThrow(() -> new BookNotFoundException("Book not found for book ID: " + bookID));
    }
}
