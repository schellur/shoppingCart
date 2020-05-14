package com.mindtree.shoppingCart.apparel.service.impl;


import com.mindtree.shoppingCart.apparel.entity.Apparel;
import com.mindtree.shoppingCart.apparel.repository.ApparelRepository;
import com.mindtree.shoppingCart.apparel.service.IApparelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author M1053969
 * Implementation class for Apparel service
 */
@Service
public class ApparelServiceImpl implements IApparelService {

    private static final Logger logger = LoggerFactory.getLogger(ApparelServiceImpl.class);

    @Autowired
    ApparelRepository apparelRepository;

    /**
     * creates the apparel product
     * @param apparelList
     */
    @Override
    public void addApparelProduct(List<Apparel> apparelList) {
        logger.info("In ApparelServiceImpl.addApparelProduct");

        apparelList.forEach(apparel -> {
            apparelRepository.save(apparel);
        });
    }
}
