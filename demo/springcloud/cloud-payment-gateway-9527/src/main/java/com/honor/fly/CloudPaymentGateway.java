package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * PACKAGE_NAME
 *
 * @author honor-ljp
 * 2023/1/16 20:36
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudPaymentGateway {
    public static void main(String[] args) {
       SpringApplication.run(CloudPaymentGateway.class, args);
    }
}
