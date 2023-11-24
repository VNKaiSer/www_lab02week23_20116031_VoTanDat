package com.example.lab02.backend.services;

import com.example.lab02.backend.models.Order;
import com.example.lab02.backend.models.OrderDetail;

import java.util.List;

public interface OrderService extends ParentService<Order> {
    List<OrderDetail> getListOrderDetail(long id);
}
