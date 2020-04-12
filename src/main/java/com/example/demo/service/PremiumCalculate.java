package com.example.demo.service;

import com.example.demo.domain.Result;

import java.util.Map;

public interface PremiumCalculate {

    Result calculate(Map<String,Object> map);
}
