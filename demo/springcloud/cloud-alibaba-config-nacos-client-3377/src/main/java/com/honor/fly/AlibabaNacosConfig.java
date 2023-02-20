package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/24 16:38
 */
@SpringBootApplication
@EnableDiscoveryClient

public class AlibabaNacosConfig {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosConfig.class, args);
    }
}
