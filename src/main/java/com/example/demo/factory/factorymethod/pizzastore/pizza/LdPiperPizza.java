package com.example.demo.factory.factorymethod.pizzastore.pizza;

public class LdPiperPizza extends Pizza {
    /**
     * 子类必须实现父类的抽象方法
     */
    @Override
    public void prepare() {
        setName("伦敦胡椒披萨");
        System.out.println(" 给伦敦胡椒披萨准备原材料");
    }
}
