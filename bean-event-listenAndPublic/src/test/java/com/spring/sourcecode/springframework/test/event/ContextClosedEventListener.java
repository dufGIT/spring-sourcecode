package com.spring.sourcecode.springframework.test.event;

import com.spring.sourcecode.springframework.context.ApplicationListener;
import com.spring.sourcecode.springframework.context.event.ContextClosedEvent;

/**
 * @Author df
 * @Date 2022/5/13 11:45
 * @Version 1.0
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件");
    }
}
