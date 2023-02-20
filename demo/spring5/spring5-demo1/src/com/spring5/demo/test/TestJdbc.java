package com.spring5.demo.test;

import com.spring5.demo.entity.Book;
import com.spring5.demo.service.BookServiceImpl;
import com.spring5.demo.service.inter.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * com.spring5.demo.test
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 22:54
 */
public class TestJdbc {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);
        /*Book book = new Book();
        book.setName("Java");
        book.setAge(20);
        bookService.insert(book);*/

        /*Book book = new Book();
        book.setAge(30);
        book.setId(1);
        bookService.update(book);*/

        /*Integer total = bookService.total();
        System.out.println("total = " + total);*/

        /*Book book = bookService.fetchOne(1);
        System.out.println("book = " + book);*/

        // 这个结果有问题
        /*List<Book> fetch = bookService.fetch(List.of(1, 2));
        System.out.println("fetch = " + fetch);*/

        /*bookService.del(1);*/

        /*List<Book> list = new ArrayList<>();
        Book book = new Book();
        book.setName("Java");
        book.setAge(50);
        Book book1 = new Book();
        book1.setName("PHP");
        book1.setAge(60);
        list.add(book1);
        list.add(book);
        bookService.batchInsert(list);*/

        /*List<Book> list = new ArrayList<>();
        Book book = new Book();
        book.setId(4);
        book.setAge(100);
        Book book1 = new Book();
        book1.setId(5);
        book1.setAge(20);
        list.add(book1);
        list.add(book);
        bookService.batchUpdate(list);*/

        List<Book> list = new ArrayList<>();
        Book book = new Book();
        book.setId(4);
        Book book1 = new Book();
        book1.setId(5);
        list.add(book1);
        list.add(book);
        bookService.batchDel(list);
    }
}
