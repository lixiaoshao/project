package com.honor.fly.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/15 20:50
 */
@Service
public class PaymentService {
    public String ok(Integer id) {
        return "ok!!!" + Thread.currentThread().getName() + "----" + id;
    }
    @HystrixCommand(fallbackMethod = "timeOuFallback",
        commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String timeOut(Integer id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "超时正常返回!!!" + Thread.currentThread().getName() + "----" + id;
    }
    public String timeOuFallback(Integer id) {
        return "超时了哦！！！" + Thread.currentThread().getName() + "---" + id;
    }
    @HystrixCommand(fallbackMethod = "circuitBreakerFallback", commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String circuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        return Thread.currentThread().getName() + "------" + IdUtil.simpleUUID();
    }
    public String circuitBreakerFallback(Integer id) {
        return "circuitBreakerFallback error:" + id;
    }
}
