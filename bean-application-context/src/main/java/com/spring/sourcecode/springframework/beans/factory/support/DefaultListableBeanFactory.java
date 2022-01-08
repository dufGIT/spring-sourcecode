package com.spring.sourcecode.springframework.beans.factory.support;

import com.spring.sourcecode.springframework.beans.BeansException;
import com.spring.sourcecode.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author df
 * @Date 2021/11/8 13:10
 * @Version 1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefination = beanDefinitionMap.get(beanName);
        if (beanDefination == null) throw new BeansException("No bean named " + beanName + " is defined");
        return beanDefination;
    }

    // 将bean定义数据循环取出并调用getBean方法，没被实例化则进行实例化
    @Override
    public void preInstantiateSingletons() throws BeansException {
        // jdk8新引入的运算符-双冒号的用法，这里beanDefinationMap.keySet()是getBean()的参数
        beanDefinationMap.keySet().forEach(this::getBean);
    }

    // 根据类的类型获取相关联的类信息
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        // xml解析出来就放入beanDefinationMap里，此时从beanDefinationMap就可以找到需要的类
        beanDefinationMap.forEach((beanName, beanDefnition) -> {
            Class beanClass = beanDefnition.getBeanClass();
            // isAssignableFrom是判断两个类之间关系的，不是实例对象关系，是本身类，是超类，是子类，是接口类通通都是true
            if (type.isAssignableFrom(beanClass)) {
                // 获取bean
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinationMap.keySet().toArray(new String[0]);
    }

     /*
        1.DefaultListableBeanFactory继承了AbstractAutowireCapableBeanFactory类，也就具备了接口BeanFactory和AbstractBeanFactory
        中的一连串的功能实现。所有有时候你会看到的一些类的强转，调用某些方法，也是因为你强转的类实现接口或继承了某些类。
        2.除此之外这个类还实现了接口BeanDefinitionRegistry中的registerBeanDefinition方法，当然你还能看到一个getBeanDefinition的实现
        这个方法我们提到过，它是抽象类AbstractBeanFactory中定义的抽象方法。现在注册bean的定义和获取bean定义就可以同时使用了，是不是感觉这个套路蛮深的
        接口定义了注册，抽象类定义了获取，都集中在DefaultListableBeanFactory中的beanDefinationMap里。
    */
}
