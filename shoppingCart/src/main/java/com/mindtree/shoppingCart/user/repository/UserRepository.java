package com.mindtree.shoppingCart.user.repository;

import com.mindtree.shoppingCart.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author M1053969
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.userName= ?1")
    public Optional<User> findByUserId( String userName);

}