package com.honor.fly.dynamicProxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * com.honor.fly.dynamicProxy
 *
 * @author honor-ljp
 * 2023/2/3 18:03
 */
public class AnimalInvocation implements InvocationHandler {
    private Object animal;
    public AnimalInvocation(Object animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        method.invoke(animal, args);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return proxy;
    }
}
