package com.example.demo.factory.factorymethod.pizzastore.pizza;

public class LdGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦希腊");
        System.out.println(" 给伦敦希腊披萨准备原材料");
    }
}
