package com.spring5.demo.service;

import com.spring5.demo.dao.BookDao;
import com.spring5.demo.entity.Book;
import com.spring5.demo.service.inter.BookExtralService;
import com.spring5.demo.service.inter.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.spring5.demo.service
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 21:30
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    BookExtralService bookExtralService;

    @Override
    public void insert(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public Integer total() {
        return bookDao.total();
    }

    @Override
    public Book fetchOne(Integer id) {
        return bookDao.fetchOne(id);
    }

    @Override
    public List<Book> fetch(List<Integer> id) {
        return bookDao.fetch(id);
    }

    @Override
    public void del(Integer id) {
        bookDao.del(id);
    }

    @Override
    public void batchInsert(List<Book> book) {
        bookDao.batchInsert(book);
    }

    @Override
    public void batchUpdate(List<Book> book) {
        bookDao.batchUpdate(book);
    }

    @Override
    public void batchDel(List<Book> book) {
        bookDao.batchDel(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void work() {
        Book book = new Book();
        book.setId(6);
        book.setAge(200);
        bookDao.update(book);
        try {
            bookExtralService.workExtra();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void workExtra() {

        Book book1 = new Book();
        book1.setId(6);
        book1.setAge(300);
        bookDao.update(book1);

    }

}
