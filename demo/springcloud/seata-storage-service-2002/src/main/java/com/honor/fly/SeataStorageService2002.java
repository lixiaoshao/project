package com.honor.fly;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/25 14:29
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoDataSourceProxy
public class SeataStorageService2002 {
    public static void main(String[] args) {
       SpringApplication.run(SeataStorageService2002.class, args);
    }
}
