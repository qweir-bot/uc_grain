package com.example.demo.DesignPattern;

/**
 * 立即加载/饿汉模式
 * 饿汉模式:
 * 优点：实现起来简单，没有多线程同步问题。
 * 缺点：当类SingletonTest被加载的时候，会初始化static的instance，
 * 静态变量被创建并分配内存空间，从这以后，这个static的instance对象
 * 便一直占着这段内存（即便你还没有用到这个实例），
 * 当类被卸载时，静态变量被摧毁，并释放所占有的内存，因此在某些特定条件下会耗费内存。
 */
public class Singleton {
    private static final Singleton instance = new Singleton();

    //私有化构造方法
    private Singleton() {

    }

    /**
     * 静态方式返回该实例
     *
     * @return
     */
    public static Singleton getInstance() {
        return instance;
    }
}
