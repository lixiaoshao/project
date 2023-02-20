package com.spring5.demo.dao;

/**
 * com.spring5.demo.dao
 *
 * @author lijianpeng@huice.com
 * 2022/12/26 22:00
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void insert(String name) {
        System.out.println("name新增成功：" + name);
    }
}
