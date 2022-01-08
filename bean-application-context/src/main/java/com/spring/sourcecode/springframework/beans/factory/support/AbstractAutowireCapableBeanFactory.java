package com.spring.sourcecode.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.spring.sourcecode.springframework.beans.BeansException;
import com.spring.sourcecode.springframework.beans.PropertyValue;
import com.spring.sourcecode.springframework.beans.PropertyValues;
import com.spring.sourcecode.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;
import com.spring.sourcecode.springframework.beans.factory.config.BeanPostProcessor;
import com.spring.sourcecode.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;


/**
 * @Author df
 * @Date 2021/11/8 11:56
 * @Version 1.0
 */
// 真正实例化Bean类，也就是说真正的获取类实例对象了
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            // 第四节注释调此种获取bean实例方式,因为对于有构造函数的bean会报错
            // 获得beanDefination里beanClass的字段的新实例
            //bean = beanDefinition.getBeanClass().newInstance();
            // 第四节更改
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行bean的初始化方法和BeanPostProcessor的前置和后置处理方法。(都是用户自定义的哦)
            bean = initializeBean(beanName, bean, beanDefinition);

        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 获取bean实例以后添加到单例对象中
        addSingleton(beanName, bean);
        return bean;
    }

    // 第四节添加*******************************************************************开始
    // 抽取createBeanInstance方法，通过beanClass.getDeclaredConstructors()获取构造函数的集合
    // 循环对比构造函数集合与入参信息的匹配情况，这里只是对一种函数数量对比，实际spring源码还需要比对入参类型
    // 否则相同数量不同入参类型的情况，就会抛异常了
    // 构造方法填充
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
    // 第四节添加***************************************************************结束

    // 第五节添加属性填充**********************************

    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    // 如遇到bean的引用，继续递归做bean的创建或者获取bean操作
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 给bean对象属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {
    }

    // 调用实例化后修改Bean对象方法
    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

}
