package com.spring.sourcecode.springframework.beans.factory;

/**
 * @Author df
 * @Date 2022/3/21 13:20
 * @Version 1.0
 */
// 特点：此接口类继承Aware接口类
// 实现此接口，就能感知到所属的beanFactory
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory);
}
