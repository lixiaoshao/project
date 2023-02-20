package com.honor.mybatisplus;

import com.honor.mybatisplus.entity.User;
import com.honor.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.honor.mybatisplus
 *
 * @author honor-ljp
 * 2022/12/30 19:48
 */
@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void insert() {
        User user = new User(null, "赵六", 30, "zhaoliu@163.com", (byte)0, 0);
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
        System.out.println("user.getId() = " + user.getId());
    }
    @Test
    public void delById() {
        int i = userMapper.deleteBatchIds(Collections.singletonList(1));
        System.out.println("i = " + i);
    }
    @Test
    public void updateById() {
        User user = new User(2L, "赵六", 30, "zhaoliu@163.com", (byte)0, 0);
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);
    }
    @Test
    public void getUserById() {
        User user = userMapper.getUserById(2L);
        System.out.println("user = " + user);
    }
    @Test
    public void selectAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
