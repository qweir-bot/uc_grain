package com.example.demo.web;

import com.example.demo.domain.Order;
import com.example.demo.domain.User;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import com.example.demo.util.BeanUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.*;

@RestController
@RequestMapping("/compose")
public class ThreadTestController {

    /**
     * 根据cpu的数量动态的配置核心线程数和最大线程数
     */
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    /**
     * 核心线程数 = CPU核心数 + 1
     */
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    /**
     * 线程池最大线程数 = CPU核心数 * 2 + 1
     */
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    /**
     * 非核心线程闲置时超时240s
     */
    private static final int KEEP_ALIVE = 240;
    /**
     * 线程池的对象
     */
    private ThreadPoolExecutor executor;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    @ResponseBody
    public Object getInfo(String id) throws Exception {
        long start,end;
        start = System.currentTimeMillis();
        //多线程：串行-->并行
        //问题线程管理
        //使用线程池
        //jdk
        //创建线程  生产环境：new ThreadPoolExecutor
        //线程之间的通信 controller call service
//        User userInfo = userService.getUserInfo(id);
//        new Runnable() {
//            @Override
//            public void run() {
//                userInfo = userService.getUserInfo(id);
//            }
//        };

        executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Callable<User> userCallable = new Callable<User>() {
            @Override
            public User call() throws Exception {
                return userService.getUserInfo(id);
            }
        };
        Future<User> userInfo = executor.submit(userCallable);
        Callable<Order> orderCallable = new Callable<Order>() {
            @Override
            public Order call() throws Exception {
                return orderService.getOrderInfo(id);
            }
        };
        Future<Order> orderInfo = executor.submit(orderCallable);
        Map<String, Object> userInfoMap = BeanUtils.beanToMap(userInfo.get());
        Map<String, Object> orderInfoMap = BeanUtils.beanToMap(orderInfo.get());




        //未使用多线程的情况
//        User userInfo = userService.getUserInfo(id);
//        Order orderInfo = orderService.getOrderInfo(id);
//        Map<String, Object> userInfoMap = BeanUtils.beanToMap(userInfo);
//        Map<String, Object> orderInfoMap = BeanUtils.beanToMap(orderInfo);

        userInfoMap.putAll(orderInfoMap);


        end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");

        return userInfoMap;
    }

    /**
     * 开启一个有返回结果的线程
     *
     * @param r
     * @return
     */
    public Future<T> submit(Callable r) {
        if (executor == null) {
            /**
             * corePoolSize:核心线程数
             * maximumPoolSize：线程池所容纳最大线程数(workQueue队列满了之后才开启)
             * keepAliveTime：非核心线程闲置时间超时时长
             * unit：keepAliveTime的单位
             * workQueue：等待队列，存储还未执行的任务
             * threadFactory：线程创建的工厂
             * handler：异常处理机制
             *
             */
            executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                    KEEP_ALIVE, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        }
        // 把一个任务丢到了线程池中
        return executor.submit(r);
    }


}
