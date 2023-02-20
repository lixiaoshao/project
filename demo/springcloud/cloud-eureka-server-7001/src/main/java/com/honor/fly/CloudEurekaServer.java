package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/11 22:00
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer {
    public static void main(String[] args) {
       SpringApplication.run(CloudEurekaServer.class, args);
    }
}
