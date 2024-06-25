package com.group_3.restful_group_3_project.wishListFolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.restful_group_3_project.userFolder.User;

@RestController
public class WishListController {

    private WishListService wishListService;

    @Autowired
    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @PostMapping(path="/users/{userID}/add-wishlist") // for wishlist creation
    public void addToWishListFolder(@PathVariable String userID, @RequestBody String wishListName) {
    wishListService.createWishlist(userID,wishListName);
    }
   
   
    @PostMapping(path="/users/{userID}/wishlists/{wishListName}/add-books")  //for adding books to a wishlist
    public void addToWishList(@PathVariable String userID, @PathVariable String wishListName, @RequestBody String isbn){
    wishListService.addToWishList(userID,wishListName,isbn);
    }
   
   
    @GetMapping(path="/users/{userID}")
public User retrieveUser(@PathVariable String userID) {
return wishListService.findByUserID(userID);
}
   
   
}
