package com.spring.sourcecode.springframework.beans.factory;

import com.spring.sourcecode.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;
import com.spring.sourcecode.springframework.beans.factory.config.BeanPostProcessor;
import com.spring.sourcecode.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author df
 * @Date 2022/1/8 21:54
 * @Version 1.0
 */
/*
 ConfigurableListableBeanFactory定义了：
 1.根据bean名称获取BeanDefinition数据方法
 2.preInstantiateSingletons()实现创建bean并存储单例bean方法
 3.添加BeanPostProcessor到集合中的方法
 并继承了ListableBeanFactory，AutowireCapableBeanFactory
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    // 此方法是在创建bean时需要先获取BeanDefinition时使用
    BeanDefinition getBeanDefinition(String beanName);

    // 此方法是自定义实例化完，需要将某些对象更改的对象进行实例化
    void preInstantiateSingletons();

    // 此方法是在自定义类都实例化完毕，开始存储BeanPostProcessor到集合中
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
