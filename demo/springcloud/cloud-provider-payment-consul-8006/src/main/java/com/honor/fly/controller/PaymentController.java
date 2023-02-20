package com.honor.fly.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/13 22:54
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/payment/port")
    public String port() {
        return port + UUID.randomUUID();
    }
}
