package com.honor.mybatisplus.service.impl;

import com.honor.mybatisplus.entity.User;
import com.honor.mybatisplus.mapper.UserMapper;
import com.honor.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author honor-ljp
 * @since 2022-12-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
