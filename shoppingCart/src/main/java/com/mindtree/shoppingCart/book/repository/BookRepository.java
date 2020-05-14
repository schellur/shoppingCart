package com.mindtree.shoppingCart.book.repository;


import com.mindtree.shoppingCart.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author M1053969
 * Book repository to perform the CRUD operations
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


}
