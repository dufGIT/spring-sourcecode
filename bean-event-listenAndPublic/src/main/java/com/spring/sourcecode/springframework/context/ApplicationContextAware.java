package com.spring.sourcecode.springframework.context;

import com.spring.sourcecode.springframework.beans.factory.Aware;

/**
 * @Author df
 * @Date 2022/3/21 13:24
 * @Version 1.0
 */
// 实现此接口，就能感知到所属的ApplicationContext
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext);
}
