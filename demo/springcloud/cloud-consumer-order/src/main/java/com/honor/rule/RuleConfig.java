package com.honor.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.honor.rule
 *
 * @author honor-ljp
 * 2023/1/14 9:20
 */
@Configuration
public class RuleConfig {
    @Bean
    IRule myRule() {
        return new RandomRule();
    }
}
