package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/14 17:17
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudConsumerFeignOrderMain {
    public static void main(String[] args) {
       SpringApplication.run(CloudConsumerFeignOrderMain.class, args);
    }
}
