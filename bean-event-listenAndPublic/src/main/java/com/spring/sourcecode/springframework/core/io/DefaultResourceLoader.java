package com.spring.sourcecode.springframework.core.io;

import org.springframework.util.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author df
 * @Date 2021/11/22 13:37
 * @Version 1.0
 */
public class DefaultResourceLoader implements ResourceLoader {
    // 根据不同的方式创建不同的资源
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        // 检测字符串是否以指定的前缀开始
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            URL url = null;
            try {
                url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
