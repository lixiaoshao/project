package com.honor.springboot.servlet;

import ch.qos.logback.core.net.server.ServerListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.net.http.WebSocket;

/**
 * com.honor.springboot.servlet
 *
 * @author honor-ljp
 * 2023/1/4 16:48
 */
//@WebListener
@Slf4j
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("contextDestroyed");
    }
}
