package com.example.demo.factory.factorymethod.pizzastore.pizza;

public class ChinaGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("中国希腊披萨");
        System.out.println(" 准备中国希腊披萨原材料 ");
    }
}
