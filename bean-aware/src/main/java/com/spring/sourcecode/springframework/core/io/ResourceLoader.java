package com.spring.sourcecode.springframework.core.io;

/**
 * @Author df
 * @Date 2021/11/22 13:36
 * @Version 1.0
 */
// 包装资源加载器
// 按照资源加载的不同方式，资源加载器可以把这些方式集中到统一的类服务下进行处理，外部用户只需要传递资源地址即可
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    // 获取资源
    Resource getResource(String location);
}
