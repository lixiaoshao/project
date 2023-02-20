package com.spring5.demo.proxy;

import com.spring5.demo.service.LoginServiceImpl;
import com.spring5.demo.service.inter.LoginService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * com.spring5.demo.proxy
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 17:32
 */
public class JdkInvocationHandler<T> implements InvocationHandler {

    private T target;
    public Object getInstance(T target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("登录方法开始前！");
        Object invoke = method.invoke(target, args);
        System.out.println("登录方法结束了！\r\n" + invoke.toString());
        return invoke;
    }
}
