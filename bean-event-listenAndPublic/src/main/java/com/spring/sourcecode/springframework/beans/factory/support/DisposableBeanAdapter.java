package com.spring.sourcecode.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.spring.sourcecode.springframework.beans.BeansException;
import com.spring.sourcecode.springframework.beans.factory.DisposableBean;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @Author df
 * @Date 2022/1/10 15:58
 * @Version 1.0
 */
// 销毁方法适配器,支持接口方式和配置方式
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy()  throws Exception {
        // 此用来实现DisposableBean的接口可直接调用
        if (bean instanceof DisposableBean) {
            System.out.println("通过适配器-调用实现DisposableBean接口的destroy()方法");
            ((DisposableBean) bean).destroy();
        }
        // 此用来将xml中配置的destroyMethodName不为空就进行反射调用，调用xml配置的销毁方法
        // 如： destroy-method="destroyDataMethod" 的  destroyDataMethod就是要调用的方法，通过invoke()调用目标方法
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            System.out.println("通过适配器-反射调用xml中配置的destroyDataMethod方法。");
            destroyMethod.invoke(bean);
        }
    }
}
