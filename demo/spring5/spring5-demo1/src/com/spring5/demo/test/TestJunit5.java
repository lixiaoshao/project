package com.spring5.demo.test;

import com.spring5.demo.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * com.spring5.demo.test
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 16:46
 */
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class TestJunit5 {
    @Autowired
    User user;

    @Test
    public void testUser() {
        user.add();
    }
}
