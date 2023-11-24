package com.example.lab02.backend.services;

import com.example.lab02.backend.models.Product;

import java.util.List;

public interface ProductService
extends ParentService<Product> {
    boolean deleteProduct(long id);
    List<Product> getProductsActive();
}
