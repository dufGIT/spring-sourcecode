package com.spring.sourcecode.springframework.beans.factory.config;

import com.spring.sourcecode.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Author df
 * @Date 2022/1/8 21:53
 * @Version 1.0
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
