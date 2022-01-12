package com.spring.sourcecode.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author df
 * @Date 2021/11/22 13:30
 * @Version 1.0
 */
// Spring框架下core.io包主要用来处理资源加载流
// 资源加载接口
public interface Resource {
    // 获取流的方法
    InputStream getInputStream() throws IOException;
}
