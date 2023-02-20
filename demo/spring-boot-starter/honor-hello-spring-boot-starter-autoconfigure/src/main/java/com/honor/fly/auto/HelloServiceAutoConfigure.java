package com.honor.fly.auto;

import com.honor.fly.entity.Hello;
import com.honor.fly.service.HelloService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.honor.fly.auto
 *
 * @author honor-ljp
 * 2023/1/10 23:55
 */
@Configuration
@EnableConfigurationProperties(Hello.class)
public class HelloServiceAutoConfigure {
    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}
