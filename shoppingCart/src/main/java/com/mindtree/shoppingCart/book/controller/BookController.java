package com.mindtree.shoppingCart.book.controller;

import com.mindtree.shoppingCart.book.entity.Book;
import com.mindtree.shoppingCart.book.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author M1053969
 * Apparel Controller class
 */
@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookServiceImpl bookService;

    /**
     * List of Book products to be created
     * @param book
     */
    @PostMapping("/addBookProducts")
    public void addProduct(@RequestBody List<Book> book){
        logger.info("In BookController.addProduct add the book products");
        bookService.addBookProduct(book);
    }
}
