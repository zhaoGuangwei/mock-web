package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页;
 * on 2018/08/14 by vitty;
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {


    /**
     * test方法;
     */
    @RequestMapping(method = RequestMethod.GET)
    public String testConnect() {
        return "first";
    }
}
