package com.spring.sourcecode.springframework.beans.factory.config;

import com.spring.sourcecode.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Author df
 * @Date 2022/1/8 21:53
 * @Version 1.0
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁
     */
    void destroySingletons();
}
