package com.honor.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.honor.mybatisplus.entity.User;
import com.honor.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * com.honor.mybatisplus
 *
 * @author honor-ljp
 * 2022/12/31 10:27
 */
@SpringBootTest
public class UserPageTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void getPageData() {
        // SELECT id,name,age,email,is_del FROM mybatis_plus_user WHERE is_del=0 AND (name LIKE ? AND age > ? OR email IS NULL) ORDER BY age DESC,id ASC LIMIT ?,?
        IPage<User> userPage = new Page<>(2, 3);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "赵")
                .gt("age", 20)
                .or()
                .isNull("email")
                .orderByDesc("age")
                .orderByAsc("id");
        IPage<User> info = userMapper.selectPage(userPage, wrapper);
        info.getRecords().forEach(System.out::println);
        System.out.println("userPage.getTotal() = " + userPage.getTotal());
        System.out.println("userPage.getCurrent() = " + userPage.getCurrent());
        System.out.println("userPage.getSize() = " + userPage.getSize());
    }
    @Test
    public void customPageMethod() {
        /*select * from mybatis_plus_user where age > ? LIMIT ?,?*/
        IPage<User> userPage = new Page<>(2, 3);
        Page<User> userListByPage = userMapper.getUserListByPage(userPage, 12);
        userListByPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void optimisticLocker() {
        User user1 = userMapper.selectById(4);
        System.out.println("user1.getAge() = " + user1.getAge());
        User user2 = userMapper.selectById(4);
        System.out.println("user2.getAge() = " + user2.getAge());
        user1.setAge(50);
        user2.setAge(35);
        int user1Result = updateAgeById(user1);
        int user2Result = updateAgeById(user2);
        System.out.println("user1Result = " + user1Result);
        System.out.println("user2Result = " + user2Result);
        User result = userMapper.selectById(4);
        System.out.println("result.getAge() = " + result.getAge());
    }

    public int updateAgeById(User user) {
        int result = userMapper.updateById(user);
        if (result == 0) {
            // 更新失败，乐观锁重试
            User user1 = userMapper.selectById(user.getId());
            user1.setAge(user.getAge());
            result = userMapper.updateById(user1);
        }
        return result;
    }
}
