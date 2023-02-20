package com.honor.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honor.mybatisplus.entity.User;
import com.honor.mybatisplus.mapper.UserMapper;
import com.honor.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * com.honor.mybatisplus.service.impl
 *
 * @author honor-ljp
 * 2022/12/30 22:12
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
