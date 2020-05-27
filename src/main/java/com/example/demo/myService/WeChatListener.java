package com.example.demo.myService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class WeChatListener implements ApplicationListener<OrderEvent> {

    private static Logger logger = LoggerFactory.getLogger(SmsListener.class);

    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        logger.info("发送微信推送成功！！！");
    }
}
