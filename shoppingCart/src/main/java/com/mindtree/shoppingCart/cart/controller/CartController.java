package com.mindtree.shoppingCart.cart.controller;

import com.mindtree.shoppingCart.Exception.ShoppingCartException;
import com.mindtree.shoppingCart.cart.model.CartInfo;
import com.mindtree.shoppingCart.cart.model.CartResult;
import com.mindtree.shoppingCart.cart.service.impl.CartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartServiceImpl cartService;

    /**
     * Add products to the cart
     * @param cartInfo
     * @throws ShoppingCartException
     */
    @PostMapping(value="/addCart")
    public void addCart(@RequestBody CartInfo cartInfo) throws ShoppingCartException {
        logger.info("In CartController.addCart ");
        cartService.addProductToCart(cartInfo);
    }

    /**
     * update the quantity of the products in the cart
     * @param cartInfo
     * @throws ShoppingCartException
     */
    @PutMapping(value="/updateCart")
    public void updateCart(@RequestBody CartInfo cartInfo) throws ShoppingCartException {
        logger.info("In CartController.updateCart ");
        cartService.updateProductInCart(cartInfo);
    }

    /**
     * View the products in the cart
     * @param cartInfo
     * @return
     */
    @PostMapping(value="/viewCart")
    public CartResult viewCart(@RequestBody CartInfo cartInfo) throws ShoppingCartException {
        logger.info("In CartController.viewCart ");
        return cartService.viewCart(cartInfo);

    }

    /**
     * delete product by product id
     * @param cartInfo
     * @throws ShoppingCartException
     */
    @PostMapping(value="/deleteProductById")
    public void deleteCartByProductId(@RequestBody CartInfo cartInfo) throws ShoppingCartException {
        logger.info("In CartController.deleteCartByProductId");
        cartService.deleteProductById(cartInfo);
    }

    /**
     * delete product all products for the user
     * @param cartInfo
     * @throws ShoppingCartException
     */
    @PostMapping(value="/deleteProductByUser")
    public void deleteCartByUser(@RequestBody CartInfo cartInfo) throws ShoppingCartException {
        logger.info("In CartController.deleteCartByUser");
        cartService.deleteProductByUser(cartInfo);
    }


}
