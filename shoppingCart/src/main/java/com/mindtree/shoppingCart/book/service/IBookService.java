package com.mindtree.shoppingCart.book.service;

import com.mindtree.shoppingCart.book.entity.Book;

import java.util.List;

/**
 * @author M1053969
 * Book Interface
 */
public interface IBookService {

    /**
     *  Creates book product
     * @param bookList
     */
    public void addBookProduct(List<Book> bookList);
}