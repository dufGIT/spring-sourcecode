package com.spring.sourcecode.springframework;

/**
 * @Author df
 * @Date 2021/11/8 9:59
 * @Version 1.0
 */
// 第一节，创建简单的bean容器
// 用于定义Bean实例化信息，现在的实现是以一个Object存放对象
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
