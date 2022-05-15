package com.spring.sourcecode.springframework.context.event;

import com.spring.sourcecode.springframework.context.ApplicationEvent;
import com.spring.sourcecode.springframework.context.ApplicationListener;

/**
 * @Author df
 * @Date 2022/5/8 20:54
 * @Version 1.0
 */

// 事件广播器
public interface ApplicationEventMulticaster {
    // 添加要通知所有事件的监听器
    void addApplicationListener(ApplicationListener<?> listener);
    // 从通知列表中删除监听器
    void removeApplicationListener(ApplicationListener<?> listener);
    // 将给定的应用程序事件多播到适当的监听器
    void multicastEvent(ApplicationEvent applicationEvent);
}
