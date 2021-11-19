package com.spring.sourcecode.springframework;

import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;
import com.spring.sourcecode.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.sourcecode.springframework.test.UserService;
import org.junit.jupiter.api.Test;

/**
 * @Author df
 * @Date 2021/11/8 13:41
 * @Version 1.0
 */
public class ApiTest04 {
    // 第四章测试
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService","xdf");
        userService.queryUserInfo();
    }
}
