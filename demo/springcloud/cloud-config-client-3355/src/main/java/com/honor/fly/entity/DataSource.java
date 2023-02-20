package com.honor.fly.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * com.honor.fly.entity
 *
 * @author honor-ljp
 * 2023/1/23 9:10
 */
@Data
@RefreshScope
@ConfigurationProperties("spring.datasource")
public class DataSource {
    private String url;
    private String username;
    private String password;
}
