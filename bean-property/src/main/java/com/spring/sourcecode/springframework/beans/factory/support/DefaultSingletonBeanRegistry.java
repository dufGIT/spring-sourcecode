package com.spring.sourcecode.springframework.beans.factory.support;


import com.spring.sourcecode.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author df
 * @Date 2021/11/8 11:32
 * @Version 1.0
 */
// 单例类注册实现方法
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<String, Object>();

    // 在此方法中主要实现了获取单例对象方法
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    // 实现了受保护的addSingleton方法，这个方法可以被继承此类的其他类调用
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
    // protected修饰符的好处是如果new 此类是不能调用addSingleton，只有继承此类才可以
}
