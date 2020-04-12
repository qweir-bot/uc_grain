package com.example.demo.service.impl;

import com.example.demo.domain.Result;
import com.example.demo.service.PremiumCalculate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("PremiumCalculate:" + 2)
public class PremiumCalculateImpl2 implements PremiumCalculate {
    @Override
    public Result calculate(Map<String, Object> map) {
        Result result = new Result();
        result.setPrice("200.00");
        return result;
    }
}
