package com.spring5.demo.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * com.spring5.demo.aop
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 20:18
 */
@Aspect
@Component
public class BookProxy {
    @Pointcut("execution(* com.spring5.demo.aop.anno.Book.add(..))")
    public void common() {

    }
    @Before("common()")
    public void before() {
        System.out.println("这是before.......");
    }
    @After("common()")
    public void after() {
        System.out.println("这是after.......");
    }
    @AfterReturning("common()")
    public void afterReturn() {
        System.out.println("这是afterReturn.......");
    }

    @AfterThrowing("common()")
    public void afterThrow() {
        System.out.println("这是afterThrow.......");
    }
    @Around("common()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("这是环绕之前.......");
        // 执行代码
        point.proceed();
        System.out.println("这是环绕之后.......");
        return "ok";
    }
}
