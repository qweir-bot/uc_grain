package com.example.demo.myServiceSale;

/**
 * 策略模式，封装算法
 */
public interface CalculateStrategy {

    public String userType();

    public double discount(double fee);
}
