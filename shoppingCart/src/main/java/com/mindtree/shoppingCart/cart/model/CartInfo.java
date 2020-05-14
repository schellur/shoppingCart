package com.mindtree.shoppingCart.cart.model;

import java.util.Objects;

/**
 * @author M1053969
 * Model class used for the request body for the Cart operations
 */
public class CartInfo {

    private String userId;

    private int quantity = 1;

    private int productId;

    /**
     * returns the user id
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     * set the user id
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * get the quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * set the quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * returns the product id
     * @return
     */
    public int getProductId() {
        return productId;
    }

    /**
     * set the product id
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }


    @Override
    public String toString() {
        return "CartInfo{" +
                "userId='" + userId + '\'' +
                ", quantity=" + quantity +
                ", productId=" + productId +
                '}';
    }
}
