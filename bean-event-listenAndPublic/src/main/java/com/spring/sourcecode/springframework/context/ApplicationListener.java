package com.spring.sourcecode.springframework.context;

import java.util.EventListener;

/**
 * @Author df
 * @Date 2022/5/13 10:27
 * @Version 1.0
 * 事件监听器
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
