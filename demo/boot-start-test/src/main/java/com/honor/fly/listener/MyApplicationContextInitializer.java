package com.honor.fly.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * com.honor.fly.listener
 *
 * @author honor-ljp
 * 2023/1/11 10:11
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("applicationContext = initialize " + applicationContext);
    }
}
