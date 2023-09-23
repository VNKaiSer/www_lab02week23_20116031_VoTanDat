package com.example.lab02.services;

import com.example.lab02.models.Product;

import java.util.List;

public interface ProductService
extends ParentService<Product> {
    boolean deleteProduct(long id);
    List<Product> getProductsActive();
}
