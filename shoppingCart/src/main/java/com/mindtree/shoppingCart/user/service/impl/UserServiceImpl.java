package com.mindtree.shoppingCart.user.service.impl;

import com.mindtree.shoppingCart.Exception.ShoppingCartException;
import com.mindtree.shoppingCart.user.entity.User;
import com.mindtree.shoppingCart.user.repository.UserRepository;
import com.mindtree.shoppingCart.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @author M1053969
 * Implementation class for User service
 */

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    /**
     * Creates new user
     * @param userObj
     * @throws ShoppingCartException
     */
    public void addUser(User userObj) throws ShoppingCartException {

        logger.info("Start - UserServiceImpl.addUser");
        Optional<User> optUser =  userRepository.findByUserId(userObj.getUserId());

        if(optUser.isPresent()){
            throw new ShoppingCartException("User id already exists. Please try with different user id");
        }else{
            userRepository.save(userObj);
        }
    }


    /**
     * returns the user by user id
     * @param userId
     * @return
     */
    @Override
    public User findUserByUserId(String userId) {

        logger.info("Start - UserServiceImpl.findUserByUserId");
        Optional<User> userOptional =  userRepository.findByUserId(userId);
        User user = null;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        logger.info("End - UserServiceImpl.findUserByUserId");
        return user;
    }

}
