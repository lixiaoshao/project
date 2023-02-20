package com.honor.fly.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * com.honor.fly.listener
 *
 * @author honor-ljp
 * 2023/1/11 10:15
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner = run" + args);
    }
}
