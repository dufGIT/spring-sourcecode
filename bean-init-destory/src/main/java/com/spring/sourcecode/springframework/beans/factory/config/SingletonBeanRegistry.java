package com.spring.sourcecode.springframework.beans.factory.config;

/**
 * @Author df
 * @Date 2021/11/8 11:30
 * @Version 1.0
 */
// 单例注册接口
public interface SingletonBeanRegistry {
    // 定义了获取单例对象的接口
    Object getSingleton(String beanName);

    /* I think by myself：此注册接口为什么只提供了getSingleton(),而没有提供addSingleton()
                         所有实现此接口的都具有了获取单例对象的权利，但是没有保存单例对象的权利
                         也就可以保证安全，而不是任意的子实现类都可以去保存添加单例对象，这样可以
                         指定想要的实现类自己去添加保存实例，如：DefaultSingletonBeanRegistry实现类
     */
}
