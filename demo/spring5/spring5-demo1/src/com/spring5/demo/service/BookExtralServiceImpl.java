package com.spring5.demo.service;

import com.spring5.demo.dao.BookDao;
import com.spring5.demo.entity.Book;
import com.spring5.demo.service.inter.BookExtralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.spring5.demo.service
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 13:04
 */
@Service
public class BookExtralServiceImpl implements BookExtralService {
    @Autowired
    BookDao bookDao;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void workExtra() {
        Book book1 = new Book();
        book1.setId(6);
        book1.setAge(300);
        bookDao.update(book1);
        int i = 10 / 0;

    }
}
