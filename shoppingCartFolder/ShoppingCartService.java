package com.group_3.restful_group_3_project.services;

import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.exceptions.BookNotFoundException;
import com.group_3.restful_group_3_project.exceptions.CartNotFoundException;
import com.group_3.restful_group_3_project.shoppingCartFolder.ShoppingCart;
import com.group_3.restful_group_3_project.shoppingCartFolder.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final BookService bookService; // Assuming you have a BookService to find books

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, BookService bookService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookService = bookService;
    }

    public double getSubtotalByUserID(String userID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            ShoppingCart cart = cartOpt.get();
            return cart.calculateSubtotal();
        }
        throw new CartNotFoundException("Cart not found for userID: " + userID);
    }

    public void addBookToCart(String userID, String bookID) throws CartNotFoundException, BookNotFoundException {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            ShoppingCart cart = cartOpt.get();
            Book book = bookService.getBookByIsbn(bookID);
            if (book != null) {
                cart.addBook(book);
                shoppingCartRepository.save(cart);
            } else {
                throw new BookNotFoundException("Book not found with ID: " + bookID);
            }
        } else {
            throw new CartNotFoundException("Cart not found for userID: " + userID);
        }
    }

    public List<Book> getBooksInCart(String userID) {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            ShoppingCart cart = cartOpt.get();
            return cart.getBooks();
        }
        throw new CartNotFoundException("Cart not found for userID: " + userID);
    }

    public void removeBookFromCart(String userID, String bookID) throws CartNotFoundException, BookNotFoundException {
        Optional<ShoppingCart> cartOpt = shoppingCartRepository.findByUserID(userID);
        if (cartOpt.isPresent()) {
            ShoppingCart cart = cartOpt.get();
            cart.removeBook(bookID);
            shoppingCartRepository.save(cart);
        } else {
            throw new CartNotFoundException("Cart not found for userID: " + userID);
        }
    }
}
