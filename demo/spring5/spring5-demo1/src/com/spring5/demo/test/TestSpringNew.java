package com.spring5.demo.test;

import com.spring5.demo.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * com.spring5.demo.test
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 16:32
 */
public class TestSpringNew {
    @Test
    public void registerBean() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
        context.registerBean("book", BookServiceImpl.class, BookServiceImpl::new);
        Object book = context.getBean("book");
        System.out.println("book = " + book);
    }
}
