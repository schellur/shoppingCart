package com.mindtree.shoppingCart.product.controller;

import com.mindtree.shoppingCart.Exception.ShoppingCartException;
import com.mindtree.shoppingCart.product.entity.Product;
import com.mindtree.shoppingCart.product.service.impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author M1053969
 *
 */
@RestController
public class ProductController {


    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductServiceImpl productService;

    @GetMapping(value="/product/{id}")
    public Product getBookProductById(@PathVariable("id") String id) throws ShoppingCartException {
        logger.info("In ProductController.getBookProductById get the book products by product id");
        return productService.getProductById(Integer.valueOf(id));
    }


    @GetMapping(value="/products/{category}")
    public List<Product> getProductByCategory(@PathVariable("category") String category) {
        logger.info("In ProductController.getProductByCategory get the products by product category");

        return productService.getProductByCategory(category);
    }

    @GetMapping(value="/products")
    public List<Product> getProductsByName(@Param("name") String name) throws ShoppingCartException {
        logger.info("In ProductController.getProductsByName get the book products by product name");
        List<Product> productList = productService.getProductByName(name);
        if(productList.size() > 0 ){
            return productList;
        }else{
            throw new ShoppingCartException("No Products found with the product name : "+name);
        }
    }
}