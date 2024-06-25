package com.group_3.restful_group_3_project.wishListFolder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.restful_group_3_project.bookFolder.Book;
import com.group_3.restful_group_3_project.bookFolder.BookRepository;
import com.group_3.restful_group_3_project.userFolder.User;
import com.group_3.restful_group_3_project.userFolder.UserRepository;

@Service
public class WishListService {

private UserRepository userRepository;  
private BookRepository bookRepository;

@Autowired
public WishListService(UserRepository userRepository, BookRepository bookRepository) {
super();
this.userRepository = userRepository;
this.bookRepository = bookRepository;
}

public boolean containsWishList(User user, String wishListName) {
List<WishList> wishlistFolder = user.getWishlistFolder();
for(WishList list: wishlistFolder) {
if(list.getWishListName().equalsIgnoreCase(wishListName)) {
return true;
}
}
return false;
}

public void createWishlist(String userID, String wishListName) {
User user = userRepository.findByUserID(userID);
if(containsWishList(user,wishListName)) {
throw new IllegalArgumentException("There is already a wishlist with this name. Please choose a new name");
}
else {
WishList newWishList = new WishList(userID, wishListName);
        user.addWishList(newWishList);
        userRepository.save(user);
}
}

    public WishList retrieveWishList(User user, String wishListName) {
    for(WishList mylist: user.getWishlistFolder()) {
    if(mylist.getWishListName().equalsIgnoreCase(wishListName)) {
    return mylist;
    }
    }
    throw new IllegalArgumentException("WishList not found");
    }
     
    public void addToWishList(String userID, String wishListName, String isbn) {
        User user = userRepository.findByUserID(userID);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        WishList myList = retrieveWishList(user, wishListName);
        if (myList == null) {
            throw new RuntimeException("WishList not found");
        }

        Book myBook = bookRepository.findByIsbn(isbn);
        if (myBook != null) {
            myList.addBook("Title: "+ myBook.getTitle() +" ISBN: "+ isbn);
        } else {
            myList.addBook("Title: Unknown title ISBN: " + isbn);
        }
        userRepository.save(user);
    }

public User findByUserID(String userID) {
return userRepository.findByUserID(userID);
}

public User save(User user) {
return userRepository.save(user);
}


}
