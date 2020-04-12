package com.example.demo.service;

import com.example.demo.domain.Order;

import java.util.List;


public interface OrderService {

    List<Order> getOrderInfos(String id);

    Order getOrderInfo(String id);
}
