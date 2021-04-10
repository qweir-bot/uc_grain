package com.example.demo;

import com.example.demo.myService.MyOrderService;
import com.example.demo.myServiceSale.SaleService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


@SpringBootTest
@WebAppConfiguration
class LambdaTest {

    private final static Logger log = getLogger(LambdaTest.class);


    @Autowired
    private MyOrderService myOrderService;


    @Test
    void test1() {

        System.out.println("is a test");
//        myOrderService.saveOrders();
        int b = 12<<3;
        System.out.println(b);
    }

    @Autowired
    private SaleService saleService;

    @Test
    void test2() {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("names:" + names.toString());
    }
}
