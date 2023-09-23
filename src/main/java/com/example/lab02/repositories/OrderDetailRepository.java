package com.example.lab02.repositories;

import com.example.lab02.models.OrderDetail;

import java.util.List;

public class OrderDetailRepository extends ParentRepository<OrderDetail> {
    public OrderDetailRepository() {
        super();
    }

    public List<OrderDetail> getListOrderDetail(long id){
        return (List<OrderDetail>) entityManager.createNamedQuery("OrderDetail.getListOrderDetail").setParameter("id", id).getResultList();
    }

}
