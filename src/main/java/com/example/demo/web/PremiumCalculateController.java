package com.example.demo.web;

import com.example.demo.domain.Order;
import com.example.demo.domain.Result;
import com.example.demo.service.OrderService;
import com.example.demo.service.PremiumCalculate;
import com.example.demo.util.PremiumCalculateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/premiumCalculate")
public class PremiumCalculateController {

    @Autowired
    private PremiumCalculateFactory premiumCalculateFactory;

    @RequestMapping(value = "/getCalculate", method = RequestMethod.GET)
    @ResponseBody
    public  Object getCalculate(String productCode){
        Map<String,Object> param = new HashMap<>();
        param.put("productCode",productCode);
        PremiumCalculate premiumCalculate = premiumCalculateFactory.getPremiumCalculate(productCode);
        Result result=  premiumCalculate.calculate(param);
        System.out.print(result.toString());
        return  result;
    }
}
