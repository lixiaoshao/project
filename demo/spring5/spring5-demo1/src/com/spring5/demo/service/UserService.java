package com.spring5.demo.service;

import com.spring5.demo.dao.UserDao;

/**
 * com.spring5.demo.service
 *
 * @author lijianpeng@huice.com
 * 2022/12/26 21:59
 */
public class UserService {
    private UserDao userDao;

    private String name;

    public UserService() {

    }
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public void add() {
        userDao.insert(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
