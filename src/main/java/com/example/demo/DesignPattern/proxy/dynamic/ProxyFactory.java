package com.example.demo.DesignPattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk代理
 * 接口代理
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //利用反射机制，返回一个代理对象
    //执行对象的方法
    public Object getProxyInstance() {

        /**
         * ClassLoader loader:指定类加载器
         * lass<?>[] interfaces:目标对象实现的接口类型
         * InvocationHandler h:执行目标对象的方法时，
         */

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK代理开始。。。");
                Object invoke = method.invoke(target, args);
                System.out.println("JDK代理提交。。。");

                return invoke;
            }
        });
    }
}
