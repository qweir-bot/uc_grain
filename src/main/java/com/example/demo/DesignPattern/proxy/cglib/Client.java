package com.example.demo.DesignPattern.proxy.cglib;


public class Client {
    /*
    1.创建代理对象
    2.创建真实对象
    3.将真实对象，交给代理对象，执行方法
     */
    public static void main(String[] args){
        TeacherDao teacherDao = new TeacherDao();
        //获取代理对象，将目标对象传递给代理对象
        TeacherDao proxyInstance =(TeacherDao)new ProxyFactory(teacherDao).getProxyInstance();
        String res = proxyInstance.teach();
        System.out.println("res:"+res);
    }
}
