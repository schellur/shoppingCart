package com.mindtree.shoppingCart.cart.model;

import com.mindtree.shoppingCart.product.entity.Product;

import java.util.List;

public class CartResult {

    private double totalPrice;

    private int totalQuantity;

    private List<Product> products;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
