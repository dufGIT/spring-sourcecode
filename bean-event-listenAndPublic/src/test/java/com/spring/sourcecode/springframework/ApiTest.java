package com.spring.sourcecode.springframework;

import com.spring.sourcecode.springframework.beans.PropertyValue;
import com.spring.sourcecode.springframework.beans.PropertyValues;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;
import com.spring.sourcecode.springframework.beans.factory.config.BeanReference;
import com.spring.sourcecode.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.sourcecode.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.spring.sourcecode.springframework.context.supprot.ClassPathXmlApplicationContext;


import com.spring.sourcecode.springframework.test.event.CustomEvent;
import org.junit.Test;


/**
 * @Author df
 * @Date 2021/11/8 13:41
 * @Version 1.0
 */
public class ApiTest {
    //
    @Test
    public void testFactoryBean() {
        // 1.初始化BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));
        applicationContext.registerShutdownHook();
        // 2.获取bean对象调用方法
        //UserService userService = applicationContext.getBean("userService", UserService.class);
        //System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
