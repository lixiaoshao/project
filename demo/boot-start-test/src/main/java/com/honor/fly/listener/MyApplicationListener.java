package com.honor.fly.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * com.honor.fly.listener
 *
 * @author honor-ljp
 * 2023/1/11 10:12
 */
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("event = onApplicationEvent " + event);
    }
}
