package com.example.demo;

import com.example.demo.myService.MyOrderService;
import com.example.demo.myServiceSale.SaleService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.slf4j.LoggerFactory.getLogger;


@SpringBootTest
@WebAppConfiguration
class DemoApplicationTest2 {

    private final static Logger log = getLogger(DemoApplicationTest2.class);


    @Autowired
    private MyOrderService myOrderService;


    @Test
    void test1() {

        System.out.println("is a test");
        myOrderService.saveOrders();
    }

    @Autowired
    private SaleService saleService;

    @Test
    void test2() {

        double normal = saleService.sale("normal", 100);
        log.info("当前用户消费金额是：" + normal);

        double vip = saleService.sale("vip", 100);
        log.info("当前用户消费金额是：" + vip);

        double svip = saleService.sale("svip", 100);
        log.info("当前用户消费金额是：" + svip);
    }
}
