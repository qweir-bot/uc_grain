package com.example.demo.myService;

import org.springframework.context.ApplicationEvent;

/**
 * 观察者模式，发布-订阅模式，也可以使用MQ实现
 */
public class OrderEvent extends ApplicationEvent {
    public OrderEvent(Object source) {
        super(source);
    }
}
