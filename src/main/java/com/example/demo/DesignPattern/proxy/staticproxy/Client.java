package com.example.demo.DesignPattern.proxy.staticproxy;

public class Client {
    /*
    1.创建代理对象
    2.创建真实对象
    3.将真实对象，交给代理对象，执行方法
     */
    public static void main(String[] args){
        TeacherDao teacherDao = new TeacherDao();
        TeacherDaoproxy teacherDaoproxy = new TeacherDaoproxy(teacherDao);
        teacherDaoproxy.teach();
    }
}
