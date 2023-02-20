package com.honor.fly.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/24 15:45
 */
@RestController
public class EchoController {
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable String str) {
        return "Hello Nacos Discovery " + str + "----" + port;
    }
}
