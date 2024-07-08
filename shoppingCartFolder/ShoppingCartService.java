package com.group_3.restful_group_3_project.shoppingCartFolder;


import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.bookFolder.BookRepository;
import com.group_3.restful_group_3_project.userFolder.User;
import com.group_3.restful_group_3_project.userFolder.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ShoppingCartService {

private final BookRepository bookRepository;
private final UserRepository userRepository;


@Autowired
public ShoppingCartService(BookRepository bookRepository, UserRepository userRepository) {
this.bookRepository = bookRepository;
this.userRepository = userRepository;
}


public double getSubtotalByUserID(String userID) {
User user = userRepository.findByUserID(userID);
if (user != null) {
return user.getShoppingCart().getSubTot();
}
throw new RuntimeException("User not found");
}



public void addBookToCart(String userID, String isbn){
User user = userRepository.findByUserID(userID);
if (user != null) {
Book book = bookRepository.findByIsbn(isbn);
if (book != null) {
ShoppingCart shoppingCart = user.getShoppingCart();
List<Book> cart_contents = shoppingCart.getBookList();
cart_contents.add(book);
Double newSubtototal = shoppingCart.getSubTot() + book.getPrice();
shoppingCart.setSubTot(newSubtototal);
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
if (user != null){
ShoppingCart cart = user.getShoppingCart();
return cart.getBookList();
}
throw new RuntimeException("User not Found");
}



public void removeBookFromCart(String userID, String isbn){
User user = userRepository.findByUserID(userID);
if (user != null){
ShoppingCart cart = user.getShoppingCart();
if(cart != null) {
List<Book> bookList = cart.getBookList();
Book bookToRemove = null;
for(Book book: bookList) {
if(book.getIsbn().equals(isbn)) {
bookToRemove = book;
break;
}
}
if(bookToRemove != null) {
bookList.remove(bookToRemove);
cart.setSubTot(calculateSubTotal(bookList));
userRepository.save(user);
} else {
throw new RuntimeException("Book not found");
}
} else {
throw new RuntimeException("Cart Empty");
}
} else {
throw new RuntimeException("User not found");
}
}


public double calculateSubTotal(List<Book> cart) {
double total = 0;
for(Book book: cart) {
total += book.getPrice();
}
return total;
}
}
