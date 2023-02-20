package com.mybatis.demo;

import com.mybatis.demo.entity.User;
import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.mybatis.demo
 *
 * @author lijianpeng@huice.com
 * 2022/12/29 11:47
 */
/***
 * DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
 * TransactionFactory transactionFactory =
 *  new JdbcTransactionFactory();
 * Environment environment =
 *  new Environment("development", transactionFactory, dataSource);
 * Configuration configuration = new Configuration(environment);
 * configuration.addMapper(BlogMapper.class);
 * SqlSessionFactory sqlSessionFactory =
 *  new SqlSessionFactoryBuilder().build(configuration);
 */
public class UserTest {
    @Test
    public void getUserById() {
        UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
        User user = userMapper.getUserById(10);
        System.out.println("user = " + user);
    }
    @Test
    public void getUserByIdAndName() {
        UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
        User user = userMapper.getUserByIdAndName(10, "超哥");
        System.out.println("user = " + user);
    }
    @Test
    public void getUserWithMap() {
        UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
        HashMap<String, Object> maps = new HashMap<>();
        maps.put("id", 10);
        maps.put("name", "超哥");
        User user = userMapper.getUserWithMap(maps);
        System.out.println("user = " + user);
    }
    @Test
    public void getUserInfo() {
        UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
        User user = userMapper.getUserInfo(10, "超哥");
        System.out.println("user = " + user);
    }
    @Test
    public void insertUser() {
        UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
        User userInfo = new User(null, "厉害哥la", "123456", 30);
        int result = userMapper.insertUser(userInfo);
        System.out.println("result = " + userInfo);
    }
    @Test
    public void getAllUserToMap() {
        UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
        Map<String, Object> result = userMapper.getAllUserToMap();
        System.out.println("result = " + result);
    }
    @Test
    public void matchUserList() {
        UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
        List<User> list = userMapper.matchUserList("超");
        System.out.println("result = " + list);
    }
    @Test
    public void delMore() {
        UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
        int i = userMapper.delMore("14,15,16");
        System.out.println("result = " + i);
    }
    @Test
    public void getUserList() {
        UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
        List<User> list = userMapper.getUserList("mybatis_user");
        list.forEach(s -> System.out.println("s = " + s));
    }
}
