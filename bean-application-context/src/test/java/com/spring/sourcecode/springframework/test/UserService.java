package com.spring.sourcecode.springframework.test;

/**
 * @Author df
 * @Date 2021/11/8 10:14
 * @Version 1.0
 */
public class UserService {
    private String uId;
    private String company;
    private UserDao userDao;
    private String location;


    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId)
                +",公司名称："+company+",地址："+location);
    }

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
}
