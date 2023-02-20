package com.honor.fly.controller;

import com.honor.fly.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/15 20:58
 */
@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "orderErrorGlobalFallbackMethod")
public class OrderController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping("/getInfoById/{id}")
    public String ok(@PathVariable("id") Integer id) {
        return paymentService.ok(id);
    }
    @RequestMapping("/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "timeOuFallback",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})*/
    @HystrixCommand
    public String timeOut(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        return paymentService.timeOut(id);
    }

    public String timeOuFallback(@PathVariable("id") Integer id) {
        return "设定1.5s调用失败返回";
    }
    public String orderErrorGlobalFallbackMethod() {
        return "全局错误。。。";
    }
}
