package com.spring5.demo.service.inter;

import com.spring5.demo.entity.Book;

import java.util.List;

/**
 * com.spring5.demo.service.inter
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 21:29
 */
public interface BookService {
    public void insert(Book book);
    public void update(Book book);
    public Integer total();
    public Book fetchOne(Integer id);
    public List<Book> fetch(List<Integer> id);
    public void del(Integer id);

    public void batchInsert(List<Book> book);
    public void batchUpdate(List<Book> book);
    public void batchDel(List<Book> book);
    public void work();
    public void workExtra();
}
