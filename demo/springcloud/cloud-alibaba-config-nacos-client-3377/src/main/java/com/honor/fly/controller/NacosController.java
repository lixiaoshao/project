package com.honor.fly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/24 17:54
 */
@RestController
public class NacosController {
    @Autowired
    private Environment env;
    @RequestMapping("/index")
    public void index() {
        String namespace = env.getProperty("namespace");
        String dataId = env.getProperty("dataId");
        String group = env.getProperty("group");
        String profile = env.getProperty("profile");
        System.out.println("namespace = " + namespace);
        System.out.println("dataId = " + dataId);
        System.out.println("group = " + group);
        System.out.println("profile = " + profile);
    }
}
