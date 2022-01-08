package com.spring.sourcecode.springframework.core.io;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author df
 * @Date 2021/11/22 13:31
 * @Version 1.0
 */
// 类路径文件流处理
public class ClassPathResource implements Resource{
    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        // spring的断言，如果空就不能往下走报错必须是不为空
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    // 获取文件流返回
    @Override
    public InputStream getInputStream() throws IOException {
        // 需要动态获取某个位置的文件可以获取文件的资源，可以采用classLoader.getResourceAsStream
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
