package com.honor.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * PACKAGE_NAME
 *
 * @author honor-ljp
 * 2023/1/24 10:58
 */
@SpringBootApplication
@EnableZipkinServer
public class CloudServiceSleuth9100 {
    public static void main(String[] args) {
       SpringApplication.run(CloudServiceSleuth9100.class, args);
    }
}
