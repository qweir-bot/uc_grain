package com.example.demo.myService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MyOrderService {

    private static Logger logger = LoggerFactory.getLogger(MyOrderService.class);

    @Autowired
    private ApplicationContext applicationContext;

    public  void saveOrders(){
        //保存订单
        logger.info("保存订单成功！");
        OrderEvent envent = new OrderEvent("参数");
        applicationContext.publishEvent(envent);
    }
}
