package com.honor.springboot.config;

import com.honor.springboot.servlet.MyFilter;
import com.honor.springboot.servlet.MyListener;
import com.honor.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.honor.springboot.config
 *
 * @author honor-ljp
 * 2023/1/5 19:55
 */
@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean myServlet() {
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet, "/servlet/my", "/servlet/theirs");
    }
    @Bean
    public FilterRegistrationBean myFilter() {
        MyFilter myFilter = new MyFilter();
        //FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter, myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.addUrlPatterns("/servlet/theirs");
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener() {
        MyListener myListener = new MyListener();
        return new ServletListenerRegistrationBean(myListener);
    }
}
