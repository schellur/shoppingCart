package com.mindtree.shoppingCart.user.service;


import com.mindtree.shoppingCart.Exception.ShoppingCartException;
import com.mindtree.shoppingCart.user.entity.User;

/**
 * @author M1053969
 * User Interface
 */
public interface IUserService {


    /**
     * Creates new user
     * @param userObj
     * @throws ShoppingCartException
     */
    public void addUser(User userObj) throws ShoppingCartException;

    /**
     * find user by user id
     * @param userId
     * @return
     */
    public User findUserByUserId(String userId);
}
