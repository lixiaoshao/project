package com.honor.fly.controller;

import com.honor.fly.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/13 23:03
 */
@RestController
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    public static final String URL = "http://consul-provider-payment";

    @RequestMapping("/order/port")
    public String getPort() {
        return restTemplate.getForObject(URL + "/payment/port", String.class);
    }
}
