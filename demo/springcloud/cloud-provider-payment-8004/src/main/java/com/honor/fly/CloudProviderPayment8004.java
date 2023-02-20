package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/13 21:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment8004 {
    public static void main(String[] args) {
       SpringApplication.run(CloudProviderPayment8004.class, args);
    }
}
