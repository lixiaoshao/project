package com.spring5.demo.aop.anno;

import org.springframework.stereotype.Service;

/**
 * com.spring5.demo.aop
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 20:17
 */
@Service
public class Book {
    public void add() {
        System.out.println("成功添加了一本书！");
    }
}
