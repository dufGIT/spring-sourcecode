package com.spring.sourcecode.springframework.context.event;

import com.spring.sourcecode.springframework.beans.factory.BeanFactory;
import com.spring.sourcecode.springframework.context.ApplicationEvent;
import com.spring.sourcecode.springframework.context.ApplicationListener;

/**
 * @Author df
 * @Date 2022/5/13 10:58
 * @Version 1.0
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    // 调用实现的事件处理器
    @Override
    public void multicastEvent(final ApplicationEvent applicationEvent) {
        for (final ApplicationListener listener : getApplicationListeners(applicationEvent)) {
            listener.onApplicationEvent(applicationEvent);
        }
    }
}
