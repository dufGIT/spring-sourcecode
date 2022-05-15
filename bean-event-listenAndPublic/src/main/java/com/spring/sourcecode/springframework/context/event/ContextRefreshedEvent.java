package com.spring.sourcecode.springframework.context.event;

/**
 * @Author df
 * @Date 2022/5/8 20:12
 * @Version 1.0
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
