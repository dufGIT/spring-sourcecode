package com.spring.sourcecode.springframework.beans.factory;

/**
 * @Author df
 * @Date 2022/4/30 10:54
 * @Version 1.0
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
