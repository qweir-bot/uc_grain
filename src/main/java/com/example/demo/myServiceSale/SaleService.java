package com.example.demo.myServiceSale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleService {

    @Autowired
    private NormalStrategy normalStrategy;

    @Autowired
    private VipStrategy vipStrategy;


//    public double sale(String type, double fee) {
////        if ("normal".equals(type)) {
////            fee = fee * 0.8;
////        } else if ("vip".equals(type)) {
////            fee = fee * 0.7;
////        }
//
//        if ("normal".equals(type)) {
//            normalStrategy.discount(fee);
//        } else if ("vip".equals(type)) {
//            vipStrategy.discount(fee);
//        }
//        return fee;
//    }

    Map<String, CalculateStrategy> calculateStrategyMap = new HashMap<>();


    public SaleService(List<CalculateStrategy> calculateStrategyList) {
        for (CalculateStrategy calculateStrategy : calculateStrategyList) {
            calculateStrategyMap.put(calculateStrategy.userType(), calculateStrategy);
        }
    }

    public double sale(String type, double fee) {
        CalculateStrategy calculateStrategy = calculateStrategyMap.get(type);
        fee = calculateStrategy.discount(fee);
        return fee;
    }
}
