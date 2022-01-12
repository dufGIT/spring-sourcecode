package com.spring.sourcecode.springframework.beanhadel;

import com.spring.sourcecode.springframework.beans.PropertyValue;
import com.spring.sourcecode.springframework.beans.PropertyValues;
import com.spring.sourcecode.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;
import com.spring.sourcecode.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Author df
 * @Date 2022/1/9 16:42
 * @Version 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "字节跳动"));

    }
}
