package com.honor.fly.service;

import com.honor.fly.entity.CommonResult;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * com.honor.fly.service
 *
 * @author honor-ljp
 * 2023/1/14 17:18
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @RequestMapping("/payment/getPayment/{id}")
    CommonResult getPayment(@PathVariable("id") Long id);
}
