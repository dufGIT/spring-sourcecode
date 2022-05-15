package com.spring.sourcecode.springframework.context;

import java.util.EventObject;

/**
 * @Author df
 * @Date 2022/5/8 18:55
 * @Version 1.0
 *
 * 抽象应用事件类
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        // 调用父类的构造方法
        super(source);
    }
}
