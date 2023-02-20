package com.spring5.demo.dao;

import com.spring5.demo.entity.Book;

import java.util.List;

/**
 * com.spring5.demo.dao
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 21:30
 */
public interface BookDao {
    public void insert(Book book);

    void update(Book book);

    Integer total();

    Book fetchOne(Integer id);

    List<Book> fetch(List<Integer> id);

    void del(Integer id);

    void batchInsert(List<Book> book);

    void batchUpdate(List<Book> book);

    void batchDel(List<Book> book);
}
