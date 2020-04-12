package com.example.demo.util;

import com.example.demo.service.PremiumCalculate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 工厂类
 */
@Component
public class PremiumCalculateFactory {
    @Autowired
    private BeanFactory beanFactory;

    public PremiumCalculate getPremiumCalculate(String productCode) {
        Object bean = beanFactory.getBean("PremiumCalculate:" + productCode);
        if (bean instanceof PremiumCalculate) {
            return (PremiumCalculate) bean;
        }
        throw new UnsupportedOperationException("不支持编码" + productCode);
    }

}
