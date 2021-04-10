package com.example.demo.factory.factorymethod.pizzastore.order;

import com.example.demo.factory.factorymethod.pizzastore.pizza.ChinaGreekPizza;
import com.example.demo.factory.factorymethod.pizzastore.pizza.ChinaPiperPizza;
import com.example.demo.factory.factorymethod.pizzastore.pizza.Pizza;

public class BjOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("greek")) {
            pizza = new ChinaGreekPizza();
        } else if (orderType.equals("pepper")) {
            pizza = new ChinaPiperPizza();
        }
        return pizza;
    }
}
