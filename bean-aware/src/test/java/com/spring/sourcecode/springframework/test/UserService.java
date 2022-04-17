package com.spring.sourcecode.springframework.test;

import com.spring.sourcecode.springframework.beans.factory.*;
import com.spring.sourcecode.springframework.context.ApplicationContext;
import com.spring.sourcecode.springframework.context.ApplicationContextAware;

/**
 * @Author df
 * @Date 2021/11/8 10:14
 * @Version 1.0
 */
public class UserService implements BeanFactoryAware, ApplicationContextAware, BeanNameAware, BeanClassLoaderAware {
    private String uId;
    private String company;
    private UserDao userDao;
    private String location;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    private String beanName;
    private ClassLoader classLoader;


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        System.out.println("this.classLoader="+classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        System.out.println("this.beanFactory="+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("this.beanName="+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        System.out.println("this.applicationContext="+applicationContext);
    }


    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId)
                + ",公司名称：" + company + ",地址：" + location);
    }

    /*@Override
    public void destroy() throws Exception {
        System.out.println("执行接口实现方式的DisposableBean：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("执行接口实现方式的InitializingBean：UserService.afterPropertiesSet");
    }*/

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }
}
