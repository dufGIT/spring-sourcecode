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

    /**
     * 向虚拟机注册钩子，将程序关闭后要调用的方法注册进去
     */
    void registerShutdownHook();

    /**
     * 关闭方法
     * */
    void close();
}