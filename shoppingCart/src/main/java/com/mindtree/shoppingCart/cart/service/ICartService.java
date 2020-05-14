package com.mindtree.shoppingCart.cart.service;

import com.mindtree.shoppingCart.Exception.ShoppingCartException;
import com.mindtree.shoppingCart.cart.model.CartInfo;
import com.mindtree.shoppingCart.cart.model.CartResult;

/**
 * @author M1053969
 *  Cart service interface
 */
public interface ICartService {

    /**
     * Add Products to cart
     * @param cartInfo
     * @throws ShoppingCartException
     */
    public void addProductToCart(CartInfo cartInfo) throws ShoppingCartException;

    /**
     * Update products in the cart
     * @param cartInfo
     * @throws ShoppingCartException
     */
    public void updateProductInCart(CartInfo cartInfo) throws ShoppingCartException;

    /**
     * view products in cart
     * @param cartInfo
     * @return
     */
    public CartResult viewCart(CartInfo cartInfo)  throws ShoppingCartException;

    /**
     * delete product from cart by product id
     * @param cartInfo
     * @throws ShoppingCartException
     */
    public void deleteProductById(CartInfo cartInfo) throws ShoppingCartException;

    /**
     * delete product
     * @param cartInfo
     * @throws ShoppingCartException
     */
    public void deleteProductByUser(CartInfo cartInfo) throws ShoppingCartException;


}
