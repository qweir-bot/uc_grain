package com.example.demo.aop;

import com.example.demo.util.BeanUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Aspect
@Order(5)
@Component
public class SetFieldValueAspect {

    @Autowired
    BeanUtil beanUtil;

    @Pointcut("@annotation(com.example.demo.annotation.NeedSetValueFiled)")
    private void cutMethod() {
        System.out.print("begin==============================");
    }


    @Around("@annotation(com.example.demo.annotation.NeedSetValueFiled)")
    public Object doSetFieldValue(ProceedingJoinPoint pjp) throws Throwable{
       //前置增强
        Object ret = pjp.proceed();

        //后置增强
        beanUtil.setFiledValueForCol((Collection)ret);
        return ret;
    }
}
