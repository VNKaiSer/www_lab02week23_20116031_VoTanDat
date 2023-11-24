package com.example.lab02.backend.services;

import com.example.lab02.backend.models.OrderDetail;

import java.util.List;

public interface OrderDetailService extends ParentService<OrderDetail> {
    List<OrderDetail> getListOrderDetailByOrder(long id);
}
