package com.group_3.restful_group_3_project.shoppingCartFolder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.bookFolder.BookRepository;
import com.group_3.restful_group_3_project.userFolder.User;
import com.group_3.restful_group_3_project.userFolder.UserRepository;

@Service
public class ShoppingCartService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public double getSubtotalByUserID(String userID) {
        User user = userRepository.findByUserID(userID);
        if (user != null) {
            ShoppingCart cart = user.getShoppingCart();
            if (cart == null) {
                cart = new ShoppingCart();
                user.setShoppingCart(cart);
                userRepository.save(user);
            }
            return cart.getSubtotal();
        }
        throw new RuntimeException("User not found");
    }

    public void addBookToCart(String userID, String isbn) {
        User user = userRepository.findByUserID(userID);
        if (user != null) {
            Book book = bookRepository.findByIsbn(isbn);
            if (book != null) {
                ShoppingCart shoppingCart = user.getShoppingCart();
                if (shoppingCart == null) {
                    shoppingCart = new ShoppingCart();
                    user.setShoppingCart(shoppingCart);
                }
                List<Book> cartContents = shoppingCart.getBookList();
                cartContents.add(book);
                double newSubtotal = shoppingCart.getSubtotal() + book.getPrice();
                shoppingCart.setSubtotal(newSubtotal);
                userRepository.save(user);
            } else {
                throw new RuntimeException("Book not found");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<Book> getBooksInCart(String userID) {
        User user = userRepository.findByUserID(userID);
        if (user != null) {
            ShoppingCart cart = user.getShoppingCart();
            if (cart == null) {
                cart = new ShoppingCart();
                user.setShoppingCart(cart);
                userRepository.save(user);
            }
            return cart.getBookList();
        }
        throw new RuntimeException("User not found");
    }

    public void removeBookFromCart(String userID, String isbn) {
        User user = userRepository.findByUserID(userID);
        if (user != null) {
            ShoppingCart cart = user.getShoppingCart();
            if (cart == null) {
                throw new RuntimeException("Cart Empty");
            }
            List<Book> bookList = cart.getBookList();
            Book bookToRemove = null;
            for (Book book : bookList) {
                if (book.getIsbn() != null && book.getIsbn().equals(isbn)) {
                    bookToRemove = book;
                    break;
                }
            }
            if (bookToRemove != null) {
                bookList.remove(bookToRemove);
                cart.setSubtotal(calculateSubTotal(bookList));
                userRepository.save(user);
            } else {
                throw new RuntimeException("Book not found");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public double calculateSubTotal(List<Book> cart) {
        double total = 0;
        for (Book book : cart) {
            total += book.getPrice();
        }
        return total;
    }
}
