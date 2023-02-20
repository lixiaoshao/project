package com.spring5.demo.test;

import com.spring5.demo.aop.anno.Book;
import com.spring5.demo.aop.xml.Computer;
import com.spring5.demo.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * com.spring5.demo.test
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 20:25
 */
public class TestAop {
    @Test
    public void testAnnotation() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        Book book = context.getBean("book", Book.class);
        book.add();
    }
    @Test
    public void testXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
        Computer computer = context.getBean("computer", Computer.class);
        computer.show();
    }
    @Test
    public void testConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Book book = context.getBean("book", Book.class);
        book.add();
    }
}
