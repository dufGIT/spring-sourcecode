package com.spring.sourcecode.springframework.beans.factory;

/**
 * @Author df
 * @Date 2022/1/12 10:44
 * @Version 1.0
 */
// 定义销毁接口
public interface DisposableBean {
    void destroy() throws Exception;
}
