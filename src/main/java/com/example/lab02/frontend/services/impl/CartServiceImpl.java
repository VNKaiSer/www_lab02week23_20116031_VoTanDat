package com.example.lab02.frontend.services.impl;


import com.example.lab02.frontend.model.ProductModel;
import com.example.lab02.frontend.services.CartSevice;

import java.util.Map;

public class CartServiceImpl implements CartSevice {

    @Override
    public void addToCart(ProductModel product) {
        if(cart.containsKey(product)) {
            cart.put(product, cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
    }

    @Override
    public void removeFromCart(ProductModel product) {
        cart.remove(product);
    }

    @Override
    public void updateQuantity(ProductModel product, int quantity) {
        cart.put(product, quantity);
    }

    @Override
    public int getQuantityInCart() {
        return cart.size();
    }

    @Override
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<ProductModel, Integer> entry : cart.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
