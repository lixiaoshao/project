package com.spring5.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * com.spring5.demo.config
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 20:52
 */
@Configuration
@ComponentScan(basePackages = {"com.spring5.demo.aop"})  // 开启注解扫描
@EnableAspectJAutoProxy  // 开启生成对象代理
public class AopConfig {

}
