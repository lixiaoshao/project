package com.honor.fly.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.honor.fly.config
 *
 * @author honor-ljp
 * 2023/1/14 22:28
 */
@Configuration
public class LoggerBean {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
