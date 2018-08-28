package com.demo.service.impl;

import com.demo.model.CacheDemo;
import com.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 构造一个空实现，不包含反序列化，验证反射执行的性能基线;
 * @Author vitty
 * @Date 2018/8/20 11:09
 */
@Service(value="contract0Service")
public class Contract0ServiceImpl implements ContractService {
    @Autowired
    private CacheDemo cacheDemo;

    /**
     * 对应于/ct0,含义是：contractTest;
     * @return
     */
    public Boolean handleContract() {
        System.out.println(cacheDemo.getInfo("hello"));
        return true;
    }

}
