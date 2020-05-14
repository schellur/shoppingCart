package com.mindtree.shoppingCart.product.service.impl;


import com.mindtree.shoppingCart.Exception.ShoppingCartException;
import com.mindtree.shoppingCart.product.entity.Product;
import com.mindtree.shoppingCart.product.repository.ProductRepository;
import com.mindtree.shoppingCart.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

/**
 * @author M1053969
 * Implementation class for Product service
 */
@Service
public class ProductServiceImpl implements IProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    /**
     * returns the product for the particular product id
     * @param productId
     * @return
     * @throws ShoppingCartException
     */
    @Override
    public Product getProductById(int productId) throws ShoppingCartException {
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()) {
            Product product = productOptional.get();
            return product;
        }else{
            throw new ShoppingCartException("No Product Found with the id "+productId);
        }
    }

    /**
     * returns the products by product category
     * @param category
     * @return
     */
    @Override
    public List<Product> getProductByCategory(String category){

        return productRepository.findByProductCategoryIgnoreCase(category);
    }

    /**
     * returns the product by product name
     * @param name
     * @return
     */
    @Override
    public List<Product> getProductByName(String name){
        return productRepository.findByProductNames(name);
    }


}
