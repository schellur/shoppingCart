package com.mindtree.shoppingCart.product.repository;


import com.mindtree.shoppingCart.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author M1053969
 * Product Repository class
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    @Query("SELECT p FROM Product p WHERE product_category = ?1")
    public List<Product> findByProductCategoryIgnoreCase(String productCategory);

    @Query("SELECT p FROM Product p WHERE productName = ?1")
    public List<Product> findByProductNames(String productName);
}
