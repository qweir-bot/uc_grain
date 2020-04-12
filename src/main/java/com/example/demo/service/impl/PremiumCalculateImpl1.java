package com.example.demo.service.impl;

import com.example.demo.domain.Result;
import com.example.demo.service.PremiumCalculate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("PremiumCalculate:"+1)
public class PremiumCalculateImpl1 implements PremiumCalculate {
    @Override
    public Result calculate(Map<String, Object> map) {
        Result result = new Result();
        result.setPrice("100.00");
        return result;
    }
}
