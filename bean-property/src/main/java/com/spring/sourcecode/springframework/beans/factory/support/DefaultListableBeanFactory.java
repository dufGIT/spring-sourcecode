package com.spring.sourcecode.springframework.beans.factory.support;

import com.spring.sourcecode.springframework.beans.BeansException;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author df
 * @Date 2021/11/8 13:10
 * @Version 1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefination = beanDefinitionMap.get(beanName);
        if (beanDefination == null) throw new BeansException("No bean named " + beanName + " is defined");
        return beanDefination;
    }

     /*
        1.DefaultListableBeanFactory继承了AbstractAutowireCapableBeanFactory类，也就具备了接口BeanFactory和AbstractBeanFactory
        中的一连串的功能实现。所有有时候你会看到的一些类的强转，调用某些方法，也是因为你强转的类实现接口或继承了某些类。
        2.除此之外这个类还实现了接口BeanDefinitionRegistry中的registerBeanDefinition方法，当然你还能看到一个getBeanDefinition的实现
        这个方法我们提到过，它是抽象类AbstractBeanFactory中定义的抽象方法。现在注册bean的定义和获取bean定义就可以同时使用了，是不是感觉这个套路蛮深的
        接口定义了注册，抽象类定义了获取，都集中在DefaultListableBeanFactory中的beanDefinationMap里。
    */
}
