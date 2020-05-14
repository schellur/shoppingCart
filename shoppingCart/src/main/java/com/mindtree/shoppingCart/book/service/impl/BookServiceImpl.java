package com.mindtree.shoppingCart.book.service.impl;

import com.mindtree.shoppingCart.book.entity.Book;
import com.mindtree.shoppingCart.book.repository.BookRepository;
import com.mindtree.shoppingCart.book.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author M1053969
 * Implementation class for Book service
 */

@Service
public class BookServiceImpl implements IBookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookRepository bookRepository;

    /**
     * Creates book product
     * @param bookList
     */
    @Override
    public void addBookProduct(List<Book> bookList) {
        logger.info("In BookServiceImpl.addBookProduct");

        bookList.forEach(book -> {
            bookRepository.save(book);
        });
    }
}
