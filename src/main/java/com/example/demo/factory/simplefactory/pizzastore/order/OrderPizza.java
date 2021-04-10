package com.example.demo.factory.simplefactory.pizzastore.order;

import com.example.demo.factory.simplefactory.pizzastore.pizza.ChinaPizza;
import com.example.demo.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.example.demo.factory.simplefactory.pizzastore.pizza.PiperPizza;
import com.example.demo.factory.simplefactory.pizzastore.pizza.Pizza;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用简单工厂设计模式，将订购操作交由工厂去实现
 */
public class OrderPizza {
    Pizza pizza = null;
    String pizzaType = "";//用户输入


    public OrderPizza(SimpleFactory simpleFactory) {
        do {
            pizzaType = getPizza();
//            pizza = this.simpleFactory.creatPizza(pizzaType);
            pizza = SimpleFactory.createPizza2(pizzaType);
            if (pizza != null) {//订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.pack();
            } else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
        } while (true);
    }

    private String getPizza() {
        try {
            //读取键盘输入
            BufferedReader bfi = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类：");
            String pizzaType = bfi.readLine();
            return pizzaType;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}
