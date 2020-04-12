package com.example.demo.DesignPattern;

/**
 * 懒汉设计模式:
 * 优点：实现起来比较简单，当类SingletonTest被加载的时候，
 * 静态变量static的instance未被创建并分配内存空间，
 * 当getInstance方法第一次被调用时，初始化instance变量，
 * 并分配内存，因此在某些特定条件下会节约了内存。
 * 缺点：在多线程环境中，这种实现方法是完全错误的，根本不能保证单例的状态。
 * 线程安全解决方式一:
 * 加synchronized优点：在多线程情形下，保证了“懒汉模式”的线程安全。
 * 加synchronied缺点：众所周知在多线程情形下，
 * synchronized方法通常效率低，显然这不是最佳的实现方案。
 */

public class Singleton3 {

    //将自身实例对象设置为一个属性，并用static修饰
    private static Singleton3 instance;

    /**
     * 私有化构造方法
     */
    private Singleton3(){

    }

    /**
     * 静态方法返回该实例,加synchronized关键字实现同步
     * @return
     */
    public static synchronized Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return  instance;
    }

}
