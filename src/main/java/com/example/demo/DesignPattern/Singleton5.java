package com.example.demo.DesignPattern;

public class Singleton5 {

    public static void main(String[] args){

    }




}

/**
 * 静态内部类的方式,推荐使用
 */
class SingletonN{
    //私有构造方法
    private SingletonN(){

    }

    private static class SingletonInstace{
        private static final SingletonN instance = new SingletonN();
    }

    public static SingletonN getInstance(){
        return SingletonInstace.instance;
    }

}
