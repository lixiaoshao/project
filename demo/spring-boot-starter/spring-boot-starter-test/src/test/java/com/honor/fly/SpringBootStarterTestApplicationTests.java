package com.honor.fly;

import com.honor.fly.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootStarterTestApplicationTests {
    @Autowired
    HelloService helloService;
    @Test
    void contextLoads() {
        String say = helloService.say();
        System.out.println("say = " + say);
    }

}
