package com.spring.sourcecode.springframework.beans.factory.support;

import com.spring.sourcecode.springframework.beans.BeansException;
import com.spring.sourcecode.springframework.beans.factory.BeanFactory;
import com.spring.sourcecode.springframework.beans.factory.FactoryBean;
import com.spring.sourcecode.springframework.beans.factory.config.BeanDefinition;
import com.spring.sourcecode.springframework.beans.factory.config.BeanPostProcessor;
import com.spring.sourcecode.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.spring.sourcecode.springframework.util.ClassUtils;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author df
 * @Date 2021/11/8 11:43
 * @Version 1.0
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    // 第三章节的getBean方式**********************开始
    /*
    抽象类的getBean方法定义了模板方法,先获取单例bean,如没获取到则取出bean定义做相应的实例化操作，
    最后创建bean,此方法是调用过程，而getBeanDefinition(获取bean定义)方法与createBean(创建bean)方法
    则是由不同的实现方法实现功能
    */
   /* @Override
    public Object getBean(String name) throws BeansException {
        // 从单例对象获取bean
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefination = getBeanDefinition(name);
        return createBean(name, beanDefination);
    }*/
    // 第三章节的getBean方式**********************结束

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        // 获取单例bean
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefination = getBeanDefinition(name);
        Object bean = createBean(name, beanDefination, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        // 容器中是否获取的到
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    // 此方法第四节传添加了一个参数为Object[] args
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    /*
    第三节学习的理解
    1.AbstractBeanFactory首先继承了DefaultSingletonBeanRegistry,也就具备了使用单例注册类方法
      如： Object bean = getSingleton(name);
    2.接下来很重要的一点是关于BeanFactory的实现，在方法getBean的实现过程中可以看到，
      主要是对单例Bean对象的获取以及获取不到时需要拿到Bean的定义做相应Bean实例化操作。那么getBean并没有自身的去实现这些方法，
      而是只定义了调用过程以及提供了抽象方法，由实现此抽象类的其他类做相应实现
    3.后续继承抽象类AbstractBeanFactory的类有两个，包括:AbstractAutowireCapableBeanFactory、
      DefaultListableBeanFactory这两个类分别做了相应的处理
 * */

}
