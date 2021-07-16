package com.zxy.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Async
    public void onApplicationEvent(DemoEvent event) {
        System.out.println("接收到demoEvent：开始发送邮件，邮件内容是：" + event.getStr());
    }

}
