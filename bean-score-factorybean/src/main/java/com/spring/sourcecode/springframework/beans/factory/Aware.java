package com.spring.sourcecode.springframework.beans.factory;

/**
 * @Author df
 * @Date 2022/3/21 13:11
 * @Version 1.0
 */
// 定义标记接口,实现该接口可以被spring感知
// 就像是一种标签一样，可以统一方便摘取出属于此类接口的实现类，通常会有instanceof一起判断使用
public interface Aware {
}