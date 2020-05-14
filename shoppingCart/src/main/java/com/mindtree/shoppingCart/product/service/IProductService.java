package com.mindtree.shoppingCart.product.service;

import com.mindtree.shoppingCart.Exception.ShoppingCartException;
import com.mindtree.shoppingCart.product.entity.Product;

import java.util.List;

public interface IProductService {

    /**
     * returns the product for the particular product id
     *
     * @param productId
     * @return
     * @throws ShoppingCartException
     */
    public Product getProductById(int productId) throws ShoppingCartException;


    /**
     * returns the products by product category
     * @param category
     * @return
     */
    public List<Product> getProductByCategory(String category);

    /**
     * returns the product by product name
     * @param name
     * @return
     */
    public List<Product> getProductByName(String name);
}
