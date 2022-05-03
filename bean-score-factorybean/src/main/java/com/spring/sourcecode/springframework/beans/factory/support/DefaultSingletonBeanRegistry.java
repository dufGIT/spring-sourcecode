package com.spring.sourcecode.springframework.beans.factory.support;


import com.spring.sourcecode.springframework.beans.BeansException;
import com.spring.sourcecode.springframework.beans.factory.DisposableBean;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;
import com.spring.sourcecode.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author df
 * @Date 2021/11/8 11:32
 * @Version 1.0
 */
// 单例类注册实现方法
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    protected static final Object NULL_OBJECT = new Object();
    private Map<String, Object> singletonObjects = new HashMap<String, Object>();
    // 要吊销的bean容器
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    // 在此方法中主要实现了获取单例对象方法
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    // 实现了受保护的addSingleton方法，这个方法可以被继承此类的其他类调用
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    // 载程序执行完该执行的就会调用此销毁方法
    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();
        System.out.println("从容器中取出要销毁的对象进行remove：" + disposableBeanNames.length);
        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            // 将容器中销毁的对象remove
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                // 调用用户自定义实现的销毁接口
                disposableBean.destroy();
            } catch (Exception e) {
                e.printStackTrace();
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

    // protected修饰符的好处是如果new 此类是不能调用addSingleton，只有继承此类才可以
}
