package com.honor.fly.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.honor.fly.config
 *
 * @author honor-ljp
 * 2023/1/23 9:04
 */
@Configuration
@EnableConfigurationProperties({com.honor.fly.entity.DataSource.class})
public class DataSource {

    @Bean("dataSourceEntity")
    com.honor.fly.entity.DataSource dataSourceEntity() {
        return new com.honor.fly.entity.DataSource();
    }
}
