package com.honor.fly.consumer;

import com.rabbitmq.client.BlockedCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * com.honor.fly.consumer
 *
 * @author honor-ljp
 * 2023/1/24 9:38
 */
@Configuration
public class StringConsumer {
    @Bean
    public Consumer<String> custom() {
        return t ->
            System.out.println("t = " + t);
    }
}
