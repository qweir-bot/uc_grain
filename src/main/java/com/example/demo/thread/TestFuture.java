package com.example.demo.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

public class TestFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("程序开始执行>>>");
        Date date1 = new Date();
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //创建多个有返回值的线程任务
        ArrayList<Future> futures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            final int taskNum = i;
            Future<Object> submit = pool.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println(">>>" + taskNum + "任务启动");
                    Date dateTmp1 = new Date();
                    Thread.sleep(1000);
                    Date dateTmp2 = new Date();
                    long time = dateTmp2.getTime() - dateTmp1.getTime();
                    System.out.println(">>>" + taskNum + "任务终止");
                    return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
//                    return null;
                }
            });
            futures.add(submit);
        }

        for (Future f : futures) {
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
                + (date2.getTime() - date1.getTime()) + "毫秒】");

    }
}