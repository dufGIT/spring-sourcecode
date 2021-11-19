package com.spring.sourcecode.springframework.beans;

/**
 * @Author df
 * @Date 2021/11/15 10:49
 * @Version 1.0
 */
// 第5节-定义属性
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
