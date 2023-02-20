package com.honor.springboot.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * com.honor.springboot.servlet
 *
 * @author honor-ljp
 * 2023/1/4 16:47
 */
//@WebFilter(urlPatterns = "/their")
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter doFilter");
    }

    @Override
    public void destroy() {
        log.info("MyFilter destroy");
    }
}
