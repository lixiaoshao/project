package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/17 16:08
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenter {
    public static void main(String[] args) {
       SpringApplication.run(CloudConfigCenter.class, args);
    }
}
