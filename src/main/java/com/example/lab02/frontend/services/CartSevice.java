package com.example.lab02.frontend.services;

import com.example.lab02.frontend.model.ProductModel;

import java.util.HashMap;
import java.util.Map;

public interface CartSevice {
    Map<ProductModel, Integer> cart = new HashMap<>();
    void addToCart(ProductModel product);
    void removeFromCart(ProductModel product);
    void updateQuantity(ProductModel product, int quantity);

    int getQuantityInCart();
    double getTotalPrice();
}
