package com.honor.fly;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/15 20:59
 */
@Service
@FeignClient(value = "cloud-payment-hystrix-service/payment", fallback = PaymentServiceFallback.class)
public interface PaymentService {
    @RequestMapping("/getInfoById/{id}")
    String ok(@PathVariable("id") Integer id);

    @RequestMapping("/timeout/{id}")
    String timeOut(@PathVariable("id") Integer id);
}
