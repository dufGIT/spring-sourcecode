package com.spring.sourcecode.springframework.context;

import com.spring.sourcecode.springframework.beans.BeansException;

/**
 * @Author df
 * @Date 2022/1/8 21:42
 * @Version 1.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}