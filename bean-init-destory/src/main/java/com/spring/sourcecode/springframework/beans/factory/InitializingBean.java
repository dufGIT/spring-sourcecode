package com.spring.sourcecode.springframework.beans.factory;

/**
 * @Author df
 * @Date 2022/1/12 10:41
 * @Version 1.0
 */
// 定义初始化接口
public interface InitializingBean {
    /*
     Bean处理了属性填充后调用
     **/
    void afterPropertiesSet();
}
