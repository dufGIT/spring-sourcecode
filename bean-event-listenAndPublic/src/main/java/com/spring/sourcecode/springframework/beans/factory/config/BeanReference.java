package com.spring.sourcecode.springframework.beans.factory.config;

/**
 * @Author df
 * @Date 2021/11/15 11:07
 * @Version 1.0
 */
// 第05节添加，做Bean的引用时使用
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
