package com.honor.fly.controller;

import com.honor.fly.entity.CommonResult;
import com.honor.fly.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/11 20:36
 */
@RestController
@RequestMapping("/payment")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${server.port}")
    private String port;

    public static final String URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @RequestMapping("/getPayment/{id}")
    public CommonResult getPayment(@PathVariable Long id) {
        System.out.println("port = " + port);
        return restTemplate.getForObject(URL + "/getPayment/" + id, CommonResult.class);
    }

    @RequestMapping("/create")
    public CommonResult getPayment(@RequestParam("serial") String serial) {
        Payment payment = new Payment(null, serial);
        return restTemplate.postForObject(URL + "/create", payment, CommonResult.class);
    }
}
