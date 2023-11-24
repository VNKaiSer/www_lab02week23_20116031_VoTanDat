package com.example.lab02.backend.services.impl;

import com.example.lab02.backend.models.Order;
import com.example.lab02.backend.models.OrderDetail;
import com.example.lab02.backend.repositories.OrderRepository;
import com.example.lab02.backend.services.OrderDetailService;
import com.example.lab02.backend.services.OrderService;

import java.util.List;

public class OrderServiceImpl
extends ParentServiceImpl<Order>
implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;
    public OrderServiceImpl() {
        orderRepository = new OrderRepository();
        orderDetailService = new OrderDetailServiceImpl();
    }

    @Override
    public List<OrderDetail> getListOrderDetail(long id) {
        return orderDetailService.getListOrderDetailByOrder(id);
    }
}
