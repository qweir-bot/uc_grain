package com.example.demo.DesignPattern.proxy.dynamic;

/**
 * jdk代理
 * 接口代理
 */
public class Client {
    /*
    1.创建代理对象
    2.创建真实对象
    3.将真实对象，交给代理对象，执行方法
     */
    public static void main(String[] args) {
        ITeacherDao target = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        ITeacherDao proxyInstance = (ITeacherDao) proxyFactory.getProxyInstance();
        System.out.println("proxyInstance:" + proxyInstance.getClass());
        proxyInstance.teach();
        proxyInstance.sayHell("tom");
    }
}
