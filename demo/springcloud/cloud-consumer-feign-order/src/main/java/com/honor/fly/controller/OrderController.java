package com.honor.fly.controller;

import com.honor.fly.entity.CommonResult;
import com.honor.fly.entity.Payment;
import com.honor.fly.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    PaymentService paymentService;

    @RequestMapping("/getPayment/{id}")
    public CommonResult getPayment(@PathVariable Long id) {
        return paymentService.getPayment(id);
    }
}
