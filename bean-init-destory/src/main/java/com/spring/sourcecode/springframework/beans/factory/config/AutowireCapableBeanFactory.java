package com.spring.sourcecode.springframework.beans.factory.config;

import com.spring.sourcecode.springframework.beans.factory.BeanFactory;

/**
 * @Author df
 * @Date 2022/1/8 21:54
 * @Version 1.0
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /*
     执行BeanPostProcessor接口实现类的postProcessBeforeInitial方法
     * */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName);


    /*
    执行BeanPostProcessor接口实现类的postProcessAfterInitialization方法
    * */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName);
}
