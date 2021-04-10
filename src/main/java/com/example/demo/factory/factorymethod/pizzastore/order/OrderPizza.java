package com.example.demo.factory.factorymethod.pizzastore.order;


import com.example.demo.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用简单工厂设计模式，将订购操作交由工厂去实现
 */
public abstract class OrderPizza {



    //定义一个抽象方法，createPizza , 让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        Pizza pizza = null;
        String pizzaType = "";//用户输入
        do {
            pizzaType = getPizza();
            pizza = createPizza(pizzaType);//抽象方法，由工厂子类完成
            if (pizza != null) {//订购成功
                //输出披萨订购过程
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
