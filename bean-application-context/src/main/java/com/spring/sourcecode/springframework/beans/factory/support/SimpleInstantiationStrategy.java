package com.spring.sourcecode.springframework.beans.factory.support;

import com.spring.sourcecode.springframework.beans.BeansException;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author df
 * @Date 2021/11/9 13:49
 * @Version 1.0
 */
// jdk实例化
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefination, String beanName, Constructor ctro, Object[] args) {
        Class clazz = beanDefination.getBeanClass();
        try {
            if (null != clazz) {
                // 实例化有参构造函数
                // 把入参
                return clazz.getDeclaredConstructor(ctro.getParameterTypes()).newInstance(args);
            } else {
                // 实例化无参构造函数
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
