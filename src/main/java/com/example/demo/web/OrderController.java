package com.example.demo.web;

import com.example.demo.config.RedisUtil;
import com.example.demo.domain.Order;
import com.example.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 锁测试共享变量
     */
    private Integer lockCount = 10;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @RequestMapping(value = "/getOrderInfo", method = RequestMethod.GET)
    @ResponseBody
    public Object getOrderInfo(String id) {

        redisUtil.set("name", "Peter");
        System.out.print(redisUtil.get("name"));
        List<Order> orders;
        if (null != redisUtil.get("order_" + id)) {
            orders = (List<Order>) redisUtil.get("order_" + id);
            System.out.print("go cache=============================");
        } else {
            orders = orderService.getOrderInfos(id);
            redisUtil.set("order_" + id, orders);
        }
        System.out.print(orders.toString());

        return orders;
    }


}
