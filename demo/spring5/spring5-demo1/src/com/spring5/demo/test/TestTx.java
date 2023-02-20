package com.spring5.demo.test;

import com.spring5.demo.config.TxConfig;
import com.spring5.demo.service.BookServiceImpl;
import com.spring5.demo.service.inter.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * com.spring5.demo.test
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 12:10
 */
public class TestTx {

    @Test
    public void xmlTx() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean9.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        bookService.work();
    }
    @Test
    public void annoTx() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        bookService.work();
    }
}
