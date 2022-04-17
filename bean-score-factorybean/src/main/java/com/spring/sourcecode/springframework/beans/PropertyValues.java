package com.spring.sourcecode.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author df
 * @Date 2021/11/15 10:54
 * @Version 1.0
 */
// 第5节-属性集合，可能一个类会有多个属性
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
