package com.spring.sourcecode.springframework.context.supprot;

import com.spring.sourcecode.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.sourcecode.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author df
 * @Date 2022/1/8 21:46
 * @Version 1.0
 */

// AbstractXmlApplicationContext抽象类主要是调用解析xml中的bean并加载到系统里，
// 继承AbstractRefreshableApplicationContext类用来创建beanFactory然后定义loadBeanDefinitions让当前子类实现
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        // 开始调用上一章节的应用上下文资源解析核心类
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        // 改为获取传过来参数配置文件的路径
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            // 获取资源并解析资源里的数据
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}

