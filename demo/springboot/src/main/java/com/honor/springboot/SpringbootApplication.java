package com.honor.springboot;

import com.honor.springboot.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("com.honor.springboot.mapper")
//@ServletComponentScan(basePackages = {"com.honor.springboot.servlet"})
public class SpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);
        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount = " + beanDefinitionCount);
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        User user1 = run.getBean("getUserBean", User.class);
        User user2 = run.getBean("getUserBean", User.class);
        System.out.println("user1 == user2 = " + (user1 == user2));
        System.out.println("user1.getCompany() = " + user1.getCompany());
    }

}
