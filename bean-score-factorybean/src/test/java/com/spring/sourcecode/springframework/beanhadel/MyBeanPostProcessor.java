package com.spring.sourcecode.springframework.beanhadel;

import com.spring.sourcecode.springframework.beans.factory.config.BeanPostProcessor;
import com.spring.sourcecode.springframework.test.UserService;

/**
 * @Author df
 * @Date 2022/1/9 16:44
 * @Version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
