package com.spring.sourcecode.springframework.test.event;

import com.spring.sourcecode.springframework.context.ApplicationListener;
import com.spring.sourcecode.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author df
 * @Date 2022/5/13 11:52
 * @Version 1.0
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件");
    }
}
