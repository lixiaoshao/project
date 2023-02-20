package com.fly.honor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HonorBootTestApplication {

    public static void main(String[] args) {
        System.out.println("开始");
        SpringApplication.run(HonorBootTestApplication.class, args);
        System.out.println("结束");
    }

}
