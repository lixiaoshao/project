package com.spring5.demo.service;

import com.spring5.demo.service.inter.LoginService;
import org.springframework.stereotype.Service;

/**
 * com.spring5.demo.service
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 17:28
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login() {
        System.out.println("登录开始了！");
        return "成功！";
    }
}
