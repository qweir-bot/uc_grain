package com.example.demo.myServiceSale;

import org.springframework.stereotype.Component;

@Component
public class VipStrategy implements CalculateStrategy {
    @Override
    public String userType() {
        return "vip";
    }

    @Override
    public double discount(double fee) {
        return fee * 0.7;
    }
}
