package com.group_3.restful_group_3_project.wishListFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
@NoArgsConstructor // Lombok annotation to create a no args constructor
@AllArgsConstructor // Lombok annotation to create a all args constructor


public class WishList {

    private String userID;
    private String wishListName;
    private List<String> books = new ArrayList<>();

    public WishList(String userID, String wishListName) {
        this.userID = userID;
        this.wishListName = wishListName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getWishListName() {
        return wishListName;
    }

    public void setWishListName(String wishListName) {
        this.wishListName = wishListName;
    }

    public List<String> getBooks() {
        return books;
    }

    public void addBook(String isbn) {
        if (isbn != null && !isbn.isEmpty()) {
            this.books.add(isbn);
        } else {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        return "WishList{" +
                "userID='" + userID + '\'' +
                ", wishListName='" + wishListName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishList wishList = (WishList) o;
        return Objects.equals(userID, wishList.userID) &&
                Objects.equals(wishListName, wishList.wishListName) &&
                Objects.equals(books, wishList.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, wishListName, books);
    }
}
