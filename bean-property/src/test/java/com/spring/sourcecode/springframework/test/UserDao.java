package com.spring.sourcecode.springframework.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author df
 * @Date 2021/11/16 10:40
 * @Version 1.0
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "hahaha");
        hashMap.put("10002", "ss");
        hashMap.put("10003", "sio");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
