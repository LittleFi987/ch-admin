package com.ych.service.impl;

import com.ych.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by chenhaoye on 2017/9/13.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "Hello";
    }

}
