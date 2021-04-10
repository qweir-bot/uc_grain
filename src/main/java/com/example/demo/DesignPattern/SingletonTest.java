package com.example.demo.DesignPattern;

public class SingletonTest {
    public static void main(String[] args){
        Singleton4 instance1 = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance1==instance2);
    }
}
