package com.spring.sourcecode.springframework.beans.factory.support;

import com.spring.sourcecode.springframework.beans.BeansException;
import com.spring.sourcecode.springframework.core.io.Resource;
import com.spring.sourcecode.springframework.core.io.ResourceLoader;

/**
 * @Author df
 * @Date 2021/11/22 13:39
 * @Version 1.0
 */
// bean定义读取接口
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    // getRegistry()与getResourceLoader()都是用于提供给这三个方法的工具，加载和注册
    void loadBeanDefinitions(Resource resource);

    void loadBeanDefinitions(Resource... resources);

    void loadBeanDefinitions(String location);

    void loadBeanDefinitions(String... locations) throws BeansException;
}
