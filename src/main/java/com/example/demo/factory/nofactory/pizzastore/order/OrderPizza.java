package com.example.demo.factory.nofactory.pizzastore.order;

import com.example.demo.factory.nofactory.pizzastore.pizza.ChinaPizza;
import com.example.demo.factory.nofactory.pizzastore.pizza.GreekPizza;
import com.example.demo.factory.nofactory.pizzastore.pizza.PiperPizza;
import com.example.demo.factory.nofactory.pizzastore.pizza.Pizza;
import org.apache.commons.lang.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 不使用设计模式，每增加一种类型都需要对订购pizza的类进行修改，
 * 如果订购被多处使用，改动量将会很大,不利于维护
 * 没有遵守ocp的设计原则，对提供者修改开发，对使用者修改关闭
 */
public class OrderPizza {
    public OrderPizza() {
        do {
            Pizza pizza = null;
            String pizzaType = "";
            pizzaType = getPizza();
            if (StringUtils.equals(pizzaType, "pipper")) {
                pizza = new PiperPizza();
                pizza.setName(pizzaType);
            } else if (StringUtils.equals(pizzaType, "greek")) {
                pizza = new GreekPizza();
                pizza.setName(pizzaType);
            }else if (StringUtils.equals(pizzaType, "china")){
                pizza = new ChinaPizza();
                pizza.setName(pizzaType);
            }

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
