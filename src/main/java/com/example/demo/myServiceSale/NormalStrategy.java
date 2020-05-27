package com.example.demo.myServiceSale;

import org.springframework.stereotype.Component;

@Component
public class NormalStrategy implements CalculateStrategy {
    @Override
    public String userType() {
        return "normal";
    }

    @Override
    public double discount(double fee) {
        return fee * 0.8;
    }
}
