package com.demo.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static com.demo.util.BaseConstants.LOCAL_CLASS_CACHE_NUM;

/**
 * @Author zhaogw
 * @Date 2018/8/23 15:07
 */
public enum LocalClassCache {
    instance;
    private Map<String,String> contractJarMap = new ConcurrentHashMap<>();

    public Map<String,String> getMap(){
        //如果map内容太多,则清除;
        if(contractJarMap.size()> LOCAL_CLASS_CACHE_NUM){
            contractJarMap.clear();
        }
        return contractJarMap;
    }
}
