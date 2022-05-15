package com.spring.sourcecode.springframework.context.supprot;

import com.spring.sourcecode.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.spring.sourcecode.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author df
 * @Date 2022/1/8 21:59
 * @Version 1.0
 */
// AbstractRefreshableApplicationContext此类主要是1.创建beanFactory，2.定义loadBeanDefinitions，3.定义获取beanFactory
// 此类继承了AbstractApplicationContext,定义了一些方法由当前类实现如：1.refreshBeanFactory(),2 getBeanFactory()
// 刷新应用上下文
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() {
        // 创建DefaultListableBeanFactory，也就是创建beanFactory
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        // 获取资源并得到数据
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    // 创建DefaultListableBeanFactory()类
    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    // 将当前创建的bean直接返回就可
    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
