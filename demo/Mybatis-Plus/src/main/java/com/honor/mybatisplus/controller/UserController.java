package com.honor.mybatisplus.controller;

import com.honor.mybatisplus.entity.User;
import com.honor.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author honor-ljp
 * @since 2022-12-31
 */
@Controller
@RequestMapping("/mybatisplus/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public User index() {
        User user = userService.getById(2);
        System.out.println("user = " + user);
        return user;
    }
}
