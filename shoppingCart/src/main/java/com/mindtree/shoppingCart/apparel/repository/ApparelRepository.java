package com.mindtree.shoppingCart.apparel.repository;


import com.mindtree.shoppingCart.apparel.entity.Apparel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author M1053969
 * Apparel repository to perform the CRUD operations
 */
@Repository
public interface ApparelRepository extends JpaRepository<Apparel, Integer> {




}
