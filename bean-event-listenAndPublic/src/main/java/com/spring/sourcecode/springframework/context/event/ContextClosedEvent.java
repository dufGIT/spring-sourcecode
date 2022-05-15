package com.spring.sourcecode.springframework.context.event;

/**
 * @Author df
 * @Date 2022/5/8 20:11
 * @Version 1.0
 * // 具体的事件定义
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
