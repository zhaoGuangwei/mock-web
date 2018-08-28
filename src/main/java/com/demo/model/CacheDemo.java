package com.demo.model;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author vitty
 * @Date 2018/8/23 16:36
 */
@Service
@CacheConfig(cacheNames = "contract")
public class CacheDemo {

    @Cacheable(key = "#name",unless="#result == null")
    public String getInfo(String name){
        System.out.println("in getInfo(),no hit cache.name:"+name);
        return "hello:"+name;
    }
}
