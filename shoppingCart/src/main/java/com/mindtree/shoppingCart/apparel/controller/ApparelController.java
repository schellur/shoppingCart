package com.mindtree.shoppingCart.apparel.controller;

import com.mindtree.shoppingCart.apparel.entity.Apparel;
import com.mindtree.shoppingCart.apparel.service.impl.ApparelServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author M1053969
 * Apparel Controller class
 */
@RestController
public class ApparelController {

    private static final Logger logger = LoggerFactory.getLogger(ApparelController.class);

    @Autowired
    ApparelServiceImpl apparelService;

    /**
     * List of Apparel products to be created
     * @param apparelList
     */
    @PostMapping("/addApparelProducts")
    public void addApparelProduct(@RequestBody List<Apparel> apparelList){
        logger.info("ApparelController.addApparelProduct");
        apparelService.addApparelProduct(apparelList);
    }

}
