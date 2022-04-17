package com.spring.sourcecode.springframework.context.supprot;

import com.spring.sourcecode.springframework.beans.factory.config.BeanPostProcessor;
import com.spring.sourcecode.springframework.context.ApplicationContext;
import com.spring.sourcecode.springframework.context.ApplicationContextAware;

/**
 * @Author df
 * @Date 2022/3/21 13:47
 * @Version 1.0
 */
// ApplicationContextAware包装处理类，主要原因是ApplicationContext所创建对象时机和beanFactoryAware等不在一块，
// 通过此类的postProcessBeforeInitialization在初始化后调用此方法来交给用户自定义赋值setApplicationContext方法得到
// ApplicationContext对象
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
