package com.honor.fly.controller;

import com.honor.fly.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/15 20:50
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping("/getInfoById/{id}")
    public String ok(@PathVariable("id") Integer id) {
        return paymentService.ok(id);
    }
    @RequestMapping("/timeout/{id}")
    public String timeOut(@PathVariable("id") Integer id) {
        return paymentService.timeOut(id);
    }
    @RequestMapping("/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.circuitBreaker(id);
    }
}
