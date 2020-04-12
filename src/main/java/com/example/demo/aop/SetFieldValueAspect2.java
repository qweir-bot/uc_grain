package com.example.demo.aop;

import com.example.demo.util.BeanUtil;
import com.example.demo.util.ReturnVO;
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
public class SetFieldValueAspect2 {

    @Autowired
    private BeanUtil beanUtil;
    /**
     * 切点
     */
//    @Pointcut("execution(* com.example.demo.web..*(..))")
//    @Pointcut("@annotation(com.example.demo.annotation.NeedSetValueFiled)")
//    public void httpResponse() {
//    }

    /**
     * 环切
     */
    @Around("@annotation(com.example.demo.annotation.NeedSetValueFiled)")
    public Object handlerController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //前置增强
        Object ret = proceedingJoinPoint.proceed();

        //后置增强
        beanUtil.setFiledValueForCol((Collection)ret);
        return ret;
    }
}
