package com.example.demo.service.impl;

import com.example.demo.annotation.NeedSetValueFiled;
import com.example.demo.dao.OrderDao;
import com.example.demo.domain.Order;
import com.example.demo.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @NeedSetValueFiled
    public List<Order> getOrderInfos(String id) {
        Order order = orderDao.getOrderInfo(id);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        return orders;
    }

    @Override
    public Order getOrderInfo(String id) {

        long start,end;
        start = System.currentTimeMillis();

        try{
            Thread.sleep(2000);

        }catch (Exception e){

        }
        end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");

        Order order = orderDao.getOrderInfo(id);
        return order;
    }
}
