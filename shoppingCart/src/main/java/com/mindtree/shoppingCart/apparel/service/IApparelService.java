package com.mindtree.shoppingCart.apparel.service;

import com.mindtree.shoppingCart.apparel.entity.Apparel;
import java.util.List;

/**
 * @author M1053969
 * Apparel Interface
 */
public interface IApparelService {

    /**
     * creates the apparel product
     * @param apparelList
     */
    public void addApparelProduct(List<Apparel> apparelList);

}
