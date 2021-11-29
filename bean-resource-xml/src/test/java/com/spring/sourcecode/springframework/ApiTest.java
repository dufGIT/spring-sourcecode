package com.spring.sourcecode.springframework;

import com.spring.sourcecode.springframework.test.UserService;
import org.junit.Test;


/**
 * @Author df
 * @Date 2021/11/8 10:13
 * @Version 1.0
 */
class ApiTest {
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}