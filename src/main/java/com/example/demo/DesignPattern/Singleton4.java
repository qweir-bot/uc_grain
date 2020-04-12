package com.example.demo.DesignPattern;

public class Singleton4 {
    //将自身实例对象设置为一个属性，并用static修饰
    private static Singleton4 instance;

    /**
     * 私有化构造方法
     */
    private Singleton4(){

    }

    /**
     * 静态方法返回该实例,加synchronized关键字实现同步
     * @return
     */
    public static synchronized Singleton4 getInstance(){
        //第一步检测instance 是否被实例化出来，如果没有进入if块
        if(instance == null){
            synchronized (Singleton4.class){
                // 某个线程取得了类锁，
                // 实例化对象前第二次检查instance是否已经被实例化出来，
                // 如果没有，才最终实例出对象
                if(instance == null){
                    instance = new Singleton4();
                }
            }
        }
        return  instance;
    }
}
