package com.spring.sourcecode.springframework.beans.factory.support;

import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author df
 * @Date 2021/11/8 13:12
 * @Version 1.0
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
