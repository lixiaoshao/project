package com.honor.fly.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * com.honor.fly.dynamicProxy
 *
 * @author honor-ljp
 * 2023/2/3 18:27
 */

@SuppressWarnings("all")
public class JdkProxyUtils {
    public static <T> T getProxyObject(T object,
                                       InvocationHandler h) {
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                new Class[]{Animal.class, SuperAnimal.class}, h);
    }
}
