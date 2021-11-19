package com.spring.sourcecode.springframework;

import com.spring.sourcecode.springframework.beans.PropertyValue;
import com.spring.sourcecode.springframework.beans.PropertyValues;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;
import com.spring.sourcecode.springframework.beans.factory.config.BeanReference;
import com.spring.sourcecode.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.sourcecode.springframework.test.UserDao;
import com.spring.sourcecode.springframework.test.UserService;
import org.junit.jupiter.api.Test;

/**
 * @Author df
 * @Date 2021/11/8 13:41
 * @Version 1.0
 */
public class ApiTest05 {
    // 第四章测试
    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.userDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3.设置属性[uId、userDao]i
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10002"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4.将UserService和属性注册到BeanDefination
        BeanDefinition beanDefination = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefination);

        // 5.userService获取bean（创建bean以后进行UserService的属性填充）
        UserService userService = (UserService) beanFactory.getBean("userService");
        // 最后userService类属性就全部填充上数据了
        userService.queryUserInfo();
    }
}
