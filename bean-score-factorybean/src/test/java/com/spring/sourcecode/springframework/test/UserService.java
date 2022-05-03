package com.spring.sourcecode.springframework.test;

import com.spring.sourcecode.springframework.beans.factory.*;
import com.spring.sourcecode.springframework.context.ApplicationContext;
import com.spring.sourcecode.springframework.context.ApplicationContextAware;

/**
 * @Author df
 * @Date 2021/11/8 10:14
 * @Version 1.0
 */
public class UserService {
    private String uId;
    private String company;
    private IUserDao userDao;
    private String location;


    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
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

}
