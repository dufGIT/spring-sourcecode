package com.spring.sourcecode.springframework.beans;

/**
 * @Author df
 * @Date 2021/11/8 10:25
 * @Version 1.0
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
