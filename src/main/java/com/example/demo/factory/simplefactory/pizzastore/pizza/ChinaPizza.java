package com.example.demo.factory.simplefactory.pizzastore.pizza;

public class ChinaPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 准备中国披萨原材料 ");
    }
}
