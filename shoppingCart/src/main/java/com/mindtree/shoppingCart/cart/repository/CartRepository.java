package com.mindtree.shoppingCart.cart.repository;

import com.mindtree.shoppingCart.cart.entity.Cart;
import com.mindtree.shoppingCart.product.entity.Product;
import com.mindtree.shoppingCart.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author M1053969
 * Repository class for cart
 */
@Repository
public interface CartRepository  extends JpaRepository<Cart, Integer> {

    @Query("SELECT c from Cart c where c.user = ?1")
    public List<Cart>  findByUser(User user);

    @Query("SELECT c FROM Cart c WHERE c.product= ?1 AND c.user= ?2")
    public Cart findByProductAndUser(Product product, User user);


    @Transactional
    @Modifying
    @Query("DELETE from Cart WHERE product = ?1 AND user = ?2")
    public void deleteByProductAndUser(Product product, User user);

    @Transactional
    @Modifying
    @Query("DELETE from Cart WHERE user = ?1")
    public void deleteByUser(User user);

    @Transactional
    @Modifying
    @Query("UPDATE Cart SET quantity= ?1 WHERE product= ?2 AND user = ?3")
    public void updateQuantity(int quantity, Product product, User user);
}
