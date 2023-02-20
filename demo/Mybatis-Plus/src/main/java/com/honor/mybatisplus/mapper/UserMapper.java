package com.honor.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.honor.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Wrapper;
import java.util.List;

/**
 * com.honor.mybatisplus.mapper
 *
 * @author honor-ljp
 * 2022/12/30 19:48
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    User getUserById(@Param("id") Long id);
    Page<User> getUserListByPage(@Param("page") IPage<User> page, @Param("age") Integer age);
}
