package com.spring.sourcecode.springframework.context.supprot;

import com.spring.sourcecode.springframework.beans.BeansException;
import com.spring.sourcecode.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.spring.sourcecode.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.spring.sourcecode.springframework.beans.factory.config.BeanPostProcessor;
import com.spring.sourcecode.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.sourcecode.springframework.context.ConfigurableApplicationContext;
import com.spring.sourcecode.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Author df
 * @Date 2022/1/8 21:44
 * @Version 1.0
 */
// 定义一些基本的上下文
// 定义一些方法，由一层一层子类实现
// 也在本类自实现了如invokeBeanFactoryPostProcessors()，registerBeanPostProcessors()
// 也实现了父类的继承的各个方法
// 实现了ConfigurableApplicationContext接口，实现refresh()
// 第7节加
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    // 使用模板方法
    @Override
    public void refresh() {
        // 1.创建beanFactory
        // 2.将创建完的beanFactory和配置文件路径传输到资源处理器里
        // 3.从资源处理器获取输入流，根据流解析bean以及属性数据并注册到bean容器里
        refreshBeanFactory();

        // 2.获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();


        // 3.在bean实例化之前，执行BeanFactoryPostProcessor(Invoke factory processors registered as beans in the context)
        // 3.1 根据BeanFactoryPostProcessor来判断是否是自定义实现子类，是就创建bean，并注册到单例类（创建自定义类Bean(MyBeanFactoryPostProcessor))
        // 3.2 根据得到的BeanFactoryPostProcessor接口来调用postProcessBeanFactory方法(此时beanDefinition里的属性已经修改)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4.BeanPostProcessor需要提前于其他Bean对象实例化之前执行注册操作
        // 4.1 通过getBeansOfType()找到与BeanPostProcessor相关的类，
        // 4.2 找到以后调用将当前的BeanPostProcessor放入集合里（做标识-后续其他bean实例创建可进行后置处理更改对象bean）
        registerBeanPostProcessors(beanFactory);


        // 5.提前实例化单例bean对象
        // 通过beanDefinationMap里的实例对象将后续bean实例进行实例化，并处理后置修改的对象
        beanFactory.preInstantiateSingletons();


    }

    protected abstract void refreshBeanFactory();

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    // 在bean实例化之前，执行BeanFactoryPostProcessor，自定义实现进行bean的修改
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        // 获取和BeanFactoryPostProcessor类有关系的的类-这里主要是获取BeanFactoryPostProcessor的子实现接口
        Map<String, BeanFactoryPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanPostProcessorMap.values()) {
            // 调用用户自定义实现的子接口
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        // 根据BeanPostProcessor获取其子实现接口
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            // 将beanPostProcessor添加到集合里
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }


    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }
}
