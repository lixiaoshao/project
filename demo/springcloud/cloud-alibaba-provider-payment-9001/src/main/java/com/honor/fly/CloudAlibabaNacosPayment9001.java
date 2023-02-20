package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/24 15:44
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosPayment9001 {
    public static void main(String[] args) {
       SpringApplication.run(CloudAlibabaNacosPayment9001.class, args);
    }
}
