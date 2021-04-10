package com.example.demo.DesignPattern.proxy.dynamic;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课中。。。。。。。。。");
    }

    @Override
    public void sayHell(String name) {
        System.out.println(name + " sayHell。。。。。。。。。");
    }
}
