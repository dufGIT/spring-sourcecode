package com.spring.sourcecode.springframework.beans.factory;

/**
 * @Author df
 * @Date 2022/3/21 13:23
 * @Version 1.0
 */
// 实现此接口，就能感知到所属的beanName
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
