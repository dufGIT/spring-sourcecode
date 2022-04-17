package com.spring.sourcecode.springframework.beans.factory.support;

import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author df
 * @Date 2021/11/9 13:29
 * @Version 1.0
 */
// 实例化策略接口
public interface InstantiationStrategy {
    // 添加必要的入参信息,还有Constructor：必要的类信息，目的是为了拿到符合入参信息相对应的构造函数
    // args具体的入参信息，最终实例化时候会用到
    Object instantiate(BeanDefinition beanDefination, String beanName, Constructor ctro, Object[] args);
}
