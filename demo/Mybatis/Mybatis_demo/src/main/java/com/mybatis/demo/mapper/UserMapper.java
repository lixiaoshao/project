package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * com.mybatis.demo.mapper
 *
 * @author lijianpeng@huice.com
 * 2022/12/29 11:40
 */
public interface UserMapper {
    int insertUser(User user);
    User getUserById(Integer id);
    List<User> getAllUser();
    User getUserByIdAndName(Integer id, String name);
    User getUserWithMap(Map<String, Object> maps);
    User getUserInfo(@Param("id") Integer id, @Param("username") String name);
    @MapKey("id")
    Map<String, Object> getAllUserToMap();
    List<User> matchUserList(@Param("str") String str);
    int delMore(@Param("str") String str);
    List<User> getUserList(@Param("table") String table);
}
