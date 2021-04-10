package com.example.demo.factory.simplefactory.pizzastore.order;

import com.example.demo.factory.simplefactory.pizzastore.pizza.ChinaPizza;
import com.example.demo.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.example.demo.factory.simplefactory.pizzastore.pizza.PiperPizza;
import com.example.demo.factory.simplefactory.pizzastore.pizza.Pizza;
import org.apache.commons.lang.StringUtils;

//简单工厂
public class SimpleFactory {
    //根据pizza类型，返回对应的pizza对象
    public Pizza creatPizza(String pizzaType) {
        Pizza pizza = null;
        if (StringUtils.equals(pizzaType, "pipper")) {
            pizza = new PiperPizza();
            pizza.setName(pizzaType);
        } else if (StringUtils.equals(pizzaType, "greek")) {
            pizza = new GreekPizza();
            pizza.setName(pizzaType);
        } else if (StringUtils.equals(pizzaType, "china")) {
            pizza = new ChinaPizza();
            pizza.setName(pizzaType);
        }
        return pizza;
    }

    //简单工厂模式 也叫 静态工厂模式
    public static Pizza createPizza2(String pizzaType) {

        Pizza pizza = null;

        System.out.println("使用简单工厂模式2");
        if (StringUtils.equals(pizzaType, "pipper")) {
            pizza = new PiperPizza();
            pizza.setName(pizzaType);
        } else if (StringUtils.equals(pizzaType, "greek")) {
            pizza = new GreekPizza();
            pizza.setName(pizzaType);
        } else if (StringUtils.equals(pizzaType, "china")) {
            pizza = new ChinaPizza();
            pizza.setName(pizzaType);
        }
        return pizza;
    }
}
