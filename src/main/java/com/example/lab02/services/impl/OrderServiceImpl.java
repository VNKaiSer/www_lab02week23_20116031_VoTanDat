package com.example.lab02.services.impl;

import com.example.lab02.models.Order;
import com.example.lab02.models.OrderDetail;
import com.example.lab02.repositories.OrderRepository;
import com.example.lab02.services.OrderDetailService;
import com.example.lab02.services.OrderService;

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
