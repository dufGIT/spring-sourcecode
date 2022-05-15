package com.spring.sourcecode.springframework.test.event;

import com.spring.sourcecode.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @Author df
 * @Date 2022/5/13 11:27
 * @Version 1.0
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
