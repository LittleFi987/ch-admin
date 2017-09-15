package com.ych.gateway.controller;

import com.ych.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by chenhaoye on 2017/9/10.
 */
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("hello")
    public String hello(){
        String s = helloService.sayHello();
        System.out.println(s);
        return "Hello World";
    }
}
