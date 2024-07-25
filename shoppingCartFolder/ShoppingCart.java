package com.group_3.restful_group_3_project.shoppingCartFolder;

import java.util.List;
import java.util.ArrayList;

import com.group_3.restful_group_3_project.bookFolder.Book;

public class ShoppingCart {
    private List<Book> bookList;
    private double subtotal;

    public ShoppingCart() {
        this.bookList = new ArrayList<>();
        this.subtotal = 0.0;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
