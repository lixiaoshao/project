package com.spring5.demo.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * com.spring5.demo.aop.xml
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 20:40
 */
public class ComputerProxy {
    public void before() {
        System.out.println("before.........");
    }
}
