package com.example.demo.myServiceSale;

import org.springframework.stereotype.Component;

@Component
public class SvipStrategy implements CalculateStrategy {
    @Override
    public String userType() {
        return "svip";
    }

    @Override
    public double discount(double fee) {
        return fee * 0.6;
    }
}
