package com.honor.fly.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/24 21:18
 */
@RestController
public class IndexController {
    @GetMapping(value = "/hello")
    @SentinelResource("hello")
    public String hello() {
        return "Hello Sentinel";
    }
}
