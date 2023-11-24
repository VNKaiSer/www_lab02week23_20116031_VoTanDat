package com.example.lab02.backend.services.impl;

import com.example.lab02.backend.models.OrderDetail;
import com.example.lab02.backend.repositories.OrderDetailRepository;
import com.example.lab02.backend.services.OrderDetailService;

import java.util.List;

public class OrderDetailServiceImpl extends ParentServiceImpl<OrderDetail> implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    public OrderDetailServiceImpl() {
        super();
        orderDetailRepository = new OrderDetailRepository();
    }
    @Override
    public List<OrderDetail> getListOrderDetailByOrder(long id) {
        return orderDetailRepository.getListOrderDetail(id);
    }
}
