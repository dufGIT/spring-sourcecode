package com.spring.sourcecode.springframework.beans.factory.config;

/**
 * @Author df
 * @Date 2022/1/8 21:49
 * @Version 1.0
 */
// 此类可以在bean对象实例化后修改bean对象，当然也可替换对象
public interface BeanPostProcessor {
    /*
     * @Author df
     * @Description 在bean对象执行初始化方法之前，执行此方法
     * @Date 11:29 2021/11/24
     * @Param [bean, beanName]
     * @return java.lang.Object
     **/
    Object postProcessBeforeInitialization(Object bean, String beanName);


    /*
     * @Author df
     * @Description 在bean对象执行初始化方法之后，执行此方法
     * @Date 11:29 2021/11/24
     * @Param [bean, beanName]
     * @return java.lang.Object
     **/
    Object postProcessAfterInitialization(Object bean, String beanName);
}