package com.spring5.demo.proxy;

import com.spring5.demo.service.LoginServiceImpl;
import com.spring5.demo.service.inter.LoginService;

/**
 * com.spring5.demo.proxy
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 17:31
 */
public class LoginProxyTest {
    public static void main(String[] args) {
        LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
        LoginService loginService = (LoginService) new JdkInvocationHandler<>().getInstance(loginServiceImpl);
        loginService.login();
    }
}
