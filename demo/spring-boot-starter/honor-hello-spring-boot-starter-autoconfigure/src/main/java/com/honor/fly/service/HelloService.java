package com.honor.fly.service;

import com.honor.fly.entity.Hello;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * com.honor.fly.service
 *
 * @author honor-ljp
 * 2023/1/10 23:47
 */

public class HelloService {
    @Autowired
    Hello hello;

    public String say() {
        return hello.getPrefix() + ":" + hello.getSuffix();
    }
}
