package com.spring.sourcecode.springframework.beans.factory.config;


import com.spring.sourcecode.springframework.beans.PropertyValues;

/**
 * @Author df
 * @Date 2021/11/8 11:26
 * @Version 1.0
 */
// Bean定义
public class BeanDefinition {
    // 按上一章的话这里已经把Object改成了Class,这样就可以把bean的实例化操作放到容器中处理了
    private Class beanClass;

    private PropertyValues propertyValues;
    // 初始化方法名称
    private String initMethodName;
    // 销毁方法名称
    private String destroyMethodName;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        // 此处加入new PropertyValues()目的是在Bean对象没有属性时后续获取会报空错，在此处理
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
