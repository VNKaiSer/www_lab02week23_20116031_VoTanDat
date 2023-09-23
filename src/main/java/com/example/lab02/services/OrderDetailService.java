package com.example.lab02.services;

import com.example.lab02.models.OrderDetail;

import java.util.List;

public interface OrderDetailService extends ParentService<OrderDetail> {
    List<OrderDetail> getListOrderDetailByOrder(long id);
}
