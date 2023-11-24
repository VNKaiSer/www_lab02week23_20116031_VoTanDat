package com.example.lab02.backend.repositories;

import com.example.lab02.backend.enums.ProductStatus;
import com.example.lab02.backend.models.Product;

import java.util.List;

public class ProductRepository
extends ParentRepository<Product>{
    public ProductRepository(){
        super();
    }

    public boolean deleteProduct(long id){
        try {
            transaction.begin();
            entityManager.createNamedQuery("Product.deleteProduct")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    public List<Product> getProductsActive(){
        return (List<Product>) entityManager.createNamedQuery("Product.getProductsActive").setParameter("status", ProductStatus.ACTIVE).getResultList();
    }
}
