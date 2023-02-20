package com.honor.fly;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/25 10:36
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoDataSourceProxy
public class SeataOrderService2001 {
    public static void main(String[] args) {
       SpringApplication.run(SeataOrderService2001.class, args);
    }
}
