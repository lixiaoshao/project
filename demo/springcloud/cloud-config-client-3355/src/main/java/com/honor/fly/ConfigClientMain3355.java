package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/23 8:59
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConfigClientMain3355.class, args);
        Object dataSourceEntity = run.getBean("dataSourceEntity");
        System.out.println("dataSourceEntity = " + dataSourceEntity);
    }
}
