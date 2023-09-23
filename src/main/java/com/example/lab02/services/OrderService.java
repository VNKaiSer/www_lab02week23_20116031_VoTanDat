package com.example.lab02.services;

import com.example.lab02.models.Order;
import com.example.lab02.models.OrderDetail;

import java.util.List;

public interface OrderService extends ParentService<Order> {
    List<OrderDetail> getListOrderDetail(long id);
}
