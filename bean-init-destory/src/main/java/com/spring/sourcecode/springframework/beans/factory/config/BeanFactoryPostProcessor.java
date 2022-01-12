package com.spring.sourcecode.springframework.beans.factory.config;

import com.spring.sourcecode.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Author df
 * @Date 2022/1/8 21:49
 * @Version 1.0
 */
public interface BeanFactoryPostProcessor {
    /*
     * @Author df
     * @Description 在所有的BeanDefinition加载完成后，实例化Bean对象之前，提供修改BeanDefinition属性的机制。
     * 相当于在bean对象注册后没有被实例化之前进行bean的修改
     * @Date 11:25 2021/11/24
     * @Param []
     * @return void
     **/
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
