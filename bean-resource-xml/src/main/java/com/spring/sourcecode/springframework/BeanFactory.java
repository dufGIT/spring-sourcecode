package com.spring.sourcecode.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author df
 * @Date 2021/11/8 10:06
 * @Version 1.0
 */
// 代表了Bean对象的工厂，可以存放Bean定义到Map中以及获取
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinationMap = new ConcurrentHashMap<String, BeanDefinition>();

    // 获取bean
    public Object getBean(String name) {
        return beanDefinationMap.get(name).getBean();
    }

    // 注册bean
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinationMap.put(name, beanDefinition);
    }
}
