package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//作用范围
@Retention(RetentionPolicy.RUNTIME)//生命周期
public @interface NeedSetValue {

    Class<?> beanClass();

    String param();

    String method();

    String targetFiled();
}
