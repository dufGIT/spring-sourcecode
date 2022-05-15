package com.spring.sourcecode.springframework.context;

/**
 * @Author df
 * @Date 2022/5/13 10:46
 * @Version 1.0
 * // 事件发布者定义
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
