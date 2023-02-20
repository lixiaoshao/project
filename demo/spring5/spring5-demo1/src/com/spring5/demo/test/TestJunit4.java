package com.spring5.demo.test;

import com.spring5.demo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * com.spring5.demo.test
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 16:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean1.xml")
public class TestJunit4 {
    @Autowired
    User user;

    @Test
    public void testUser() {
        user.add();
    }
}
