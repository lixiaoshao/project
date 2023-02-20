package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/15 20:31
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudPaymentHystrixService8002 {
    public static void main(String[] args) {
       SpringApplication.run(CloudPaymentHystrixService8002.class, args);
    }
}
