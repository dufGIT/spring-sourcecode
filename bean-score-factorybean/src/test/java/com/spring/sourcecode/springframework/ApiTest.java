package com.spring.sourcecode.springframework;

import com.spring.sourcecode.springframework.beans.PropertyValue;
import com.spring.sourcecode.springframework.beans.PropertyValues;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;
import com.spring.sourcecode.springframework.beans.factory.config.BeanReference;
import com.spring.sourcecode.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.sourcecode.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.spring.sourcecode.springframework.context.supprot.ClassPathXmlApplicationContext;

import com.spring.sourcecode.springframework.test.UserService;
import org.junit.Test;


/**
 * @Author df
 * @Date 2021/11/8 13:41
 * @Version 1.0
 */
public class ApiTest {
    //
    @Test
    public void test_xml() {
        // 1.初始化BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2.获取bean对象调用方法
        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        // 2. 获取Bean对象调用方法
        UserService userService2 = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService1);
        System.out.println(userService2);
    }
}
