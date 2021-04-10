package com.example.demo.factory.factorymethod.pizzastore.order;

import com.example.demo.factory.factorymethod.pizzastore.pizza.*;

public class LdOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("greek")) {
            pizza = new LdGreekPizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LdPiperPizza();
        }
        return pizza;
    }
}
