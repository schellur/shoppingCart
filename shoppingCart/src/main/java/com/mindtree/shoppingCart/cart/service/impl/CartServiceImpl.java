package com.mindtree.shoppingCart.cart.service.impl;

import com.mindtree.shoppingCart.Exception.ShoppingCartException;
import com.mindtree.shoppingCart.cart.entity.Cart;
import com.mindtree.shoppingCart.cart.model.CartInfo;
import com.mindtree.shoppingCart.cart.model.CartResult;
import com.mindtree.shoppingCart.cart.repository.CartRepository;
import com.mindtree.shoppingCart.cart.service.ICartService;
import com.mindtree.shoppingCart.product.entity.Product;
import com.mindtree.shoppingCart.product.service.impl.ProductServiceImpl;
import com.mindtree.shoppingCart.user.entity.User;
import com.mindtree.shoppingCart.user.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author M1053969
 * Implementation class for the Cart service
 */
@Service
public class CartServiceImpl implements ICartService {

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProductServiceImpl productService;

    /**
     * Add Products to cart
     * @param cartInfo
     * @throws ShoppingCartException
     */
    @Override
    public void addProductToCart(CartInfo cartInfo) throws ShoppingCartException {

        logger.info("Start - CartServiceImpl.addProductToCart");

        User user = userService.findUserByUserId(cartInfo.getUserId());

        if(null == user){
            // user doesnt exists create a user
            user = new User();
            user.setUserId(cartInfo.getUserId());
            user.setUserName(cartInfo.getUserId());
            userService.addUser(user);
        }

        Product product = productService.getProductById(cartInfo.getProductId());

        Cart cart = null;
        cart = cartRepository.findByProductAndUser(product,user);

        if(null != cart){
            int quantity = cart.getQuantity();
            quantity++;
            cart.setQuantity(quantity);
            cartRepository.updateQuantity(quantity,product,user);
        }
        else{
            cart = new Cart();
            cart.setProduct(product);
            cart.setUser(user);
            cart.setCartId(System.currentTimeMillis());
            cart.setQuantity(cartInfo.getQuantity());
            cartRepository.save(cart);
        }

        logger.info("End - CartServiceImpl.addProductToCart");
    }

    /**
     * Update products in the cart
     * @param cartInfo
     * @throws ShoppingCartException
     */
    @Override
    public void updateProductInCart(CartInfo cartInfo) throws ShoppingCartException {

        logger.info("Start - CartServiceImpl.updateProductInCart");

        User user = userService.findUserByUserId(cartInfo.getUserId());
        Product product = productService.getProductById(cartInfo.getProductId());

        Cart cart = cartRepository.findByProductAndUser(product,user);
        if(null != cart){
            if(cartInfo.getQuantity() < 0 ){
                throw new ShoppingCartException("Quantity should not be negative");
            }else if(cartInfo.getQuantity() == 0){
                cartRepository.deleteById(cart.getId());
            }else {
                cart.setQuantity(cartInfo.getQuantity());
                cartRepository.updateQuantity(cartInfo.getQuantity(),product,user);
            }
        }
        logger.info("End - CartServiceImpl.updateProductInCart");
    }


    /**
     * view products in cart
     * @param cartInfo
     * @return
     */
    @Override
    public CartResult viewCart(CartInfo cartInfo) throws ShoppingCartException{

        logger.info("Start - CartServiceImpl.viewCart");

        User user = userService.findUserByUserId(cartInfo.getUserId());

        List<Cart> cartList = cartRepository.findByUser(user);
        CartResult cartResult = new CartResult();
        List<Product> resultList = new ArrayList<>();

        cartList.forEach(cart -> {
            Product product = null;
            try {
                product = productService.getProductById(cart.getProduct().getProductId());
            } catch (ShoppingCartException e) {
            }

            if(null != product){
                resultList.add(product);
                cartResult.setTotalPrice(cartResult.getTotalPrice()+
                        (product.getProductPrice() * cart.getQuantity()));
                cartResult.setTotalQuantity((cartResult.getTotalQuantity() + 1)*cart.getQuantity());
            }
        });

        cartResult.setProducts(resultList);
        logger.info("End - CartServiceImpl.viewCart");
        return cartResult;
    }

    /**
     * delete product from cart by product id
     * @param cartInfo
     * @throws ShoppingCartException
     */
    @Override
    public void deleteProductById(CartInfo cartInfo) throws ShoppingCartException {

        logger.info("Start - CartServiceImpl.deleteProductById");
        User user = userService.findUserByUserId(cartInfo.getUserId());

        Product product = null;
        if(cartInfo.getProductId() != 0) {
            product = productService.getProductById(cartInfo.getProductId());
            Cart cart = null;
            cart = cartRepository.findByProductAndUser(product, user);
            if (null != cart) {
                cartRepository.deleteByProductAndUser(product, user);
            }
        }
        logger.info("End - CartServiceImpl.deleteProductById");
    }


    /**
     * delete all products from cart by user
     * @param cartInfo
     * @throws ShoppingCartException
     */
    @Override
    public void deleteProductByUser(CartInfo cartInfo) throws ShoppingCartException {

        logger.info("Start - CartServiceImpl.deleteProductByUser");
        User user = userService.findUserByUserId(cartInfo.getUserId());
        if(null != user){
            cartRepository.deleteByUser(user);
        }
        logger.info("End - CartServiceImpl.deleteProductByUser");
    }
}