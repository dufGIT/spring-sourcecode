package com.spring.sourcecode.springframework.util;

/**
 * @Author df
 * @Date 2021/11/22 13:32
 * @Version 1.0
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader c1 = null;
        try {
            // 得到的是当前ClassPath的ClassLoader
            c1 = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }
        if (c1 == null) {
            // no thread context class loader-> use class loader of this class.
            // 使用ClassUtils类的类加载器
            c1 = ClassUtils.class.getClassLoader();
        }
        return c1;
    }
}
