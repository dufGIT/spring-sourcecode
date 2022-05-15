package com.spring.sourcecode.springframework.beans.factory;

import com.spring.sourcecode.springframework.beans.BeansException;

/**
 * @Author df
 * @Date 2021/11/8 10:26
 * @Version 1.0
 */
// 定义bean工厂接口
public interface BeanFactory {
    // 获取bean
    Object getBean(String name) throws BeansException;

    // 04章节-添加,可以传参数
    Object getBean(String name,Object... args);

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
