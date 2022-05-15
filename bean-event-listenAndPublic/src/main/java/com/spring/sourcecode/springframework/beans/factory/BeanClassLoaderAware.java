package com.spring.sourcecode.springframework.beans.factory;

/**
 * @Author df
 * @Date 2022/3/21 13:29
 * @Version 1.0
 */
// 实现此接口，既能感知到所属的ClassLoader
public interface BeanClassLoaderAware  extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
