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

    //如果调用同类中的缓存方法，不生效，此时可以直接构建本地缓存;
    @Cacheable(key = "#name",unless="#result == null")
    public String getInfoInClass(String name){
        System.out.println("in getInfoInClass(),no hit cache.name:"+name);
        return "inClass:"+name;
    }
    public String invokeInfoInClass(String name){
        return this.getInfoInClass("inClass:"+name);
    }

    public String getInfoByMap(String name){
        if(LocalClassCache.instance.getMap().containsKey(name)){
            System.out.println("in getInfoByMap(),hit cache.name:"+name);
            return LocalClassCache.instance.getMap().get(name);
        }
        System.out.println("in getInfoByMap(),no hit cache.name:"+name);
        String result = "byMap:"+name;
        LocalClassCache.instance.getMap().put(name,result);
        return result;
    }
}
