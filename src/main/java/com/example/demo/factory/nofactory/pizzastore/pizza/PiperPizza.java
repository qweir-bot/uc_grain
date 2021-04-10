package com.example.demo.factory.nofactory.pizzastore.pizza;

public class PiperPizza extends Pizza {
    /**
     * 子类必须实现父类的抽象方法
     */
    @Override
    public void prepare() {
        System.out.println(" 给胡椒披萨准备原材料");
    }
}
