package com.demo.akka;

import org.springframework.stereotype.Component;

/**
 * @Author vitty
 * @Date 2018/8/24 11:07
 */
@Component
public class GreetingService {

    public String greet(String name) {
        return "Hello, " + name;
    }
}
