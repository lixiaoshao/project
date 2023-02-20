package com.honor.mybatisplus;

import com.honor.mybatisplus.entity.User;
import com.honor.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * com.honor.mybatisplus
 *
 * @author honor-ljp
 * 2022/12/30 22:17
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void getUserCount() {
        long count = userService.count();
        System.out.println("count = " + count);
    }
    @Test
    public void batchInsert() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(null, "赵六" + i, 30 + i, "zhaoliu@163.com", (byte)0, 0);
            list.add(user);
        }
        userService.saveBatch(list);
    }
}
