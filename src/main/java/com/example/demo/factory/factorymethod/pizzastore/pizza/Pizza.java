package com.example.demo.factory.factorymethod.pizzastore.pizza;

/**
 * 将pizza类设计为抽象类
 */
public abstract class Pizza {

    protected String name;//pizza名字
    //准备原材料，不同类型的pizza不同，因此我们做成抽象方法
    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cuting;");
    }

    public void pack() {
        System.out.println(name + " packing;");
    }

    public void setName(String name){
        this.name = name;
    }
}
