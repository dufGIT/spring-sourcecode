package com.spring.sourcecode.springframework.context.event;

import com.spring.sourcecode.springframework.context.ApplicationContext;
import com.spring.sourcecode.springframework.context.ApplicationEvent;

/**
 * @Author df
 * @Date 2022/5/8 19:00
 * @Version 1.0
 *
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /*public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }*/


}
