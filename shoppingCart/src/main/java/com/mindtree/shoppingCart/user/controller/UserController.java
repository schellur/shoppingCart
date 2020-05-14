package com.mindtree.shoppingCart.user.controller;

import com.mindtree.shoppingCart.Exception.ShoppingCartException;
import com.mindtree.shoppingCart.user.entity.User;
import com.mindtree.shoppingCart.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author M1053969
 * User controller class
 */
@RestController
public class UserController {


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) throws ShoppingCartException{
        logger.info("In UserController.addUser");
        userService.addUser(user);

    }


}
