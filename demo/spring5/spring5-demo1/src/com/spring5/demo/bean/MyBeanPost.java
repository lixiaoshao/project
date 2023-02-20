package com.spring5.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * com.spring5.demo.bean
 *
 * @author lijianpeng@huice.com
 * 2022/12/27 10:04
 */
public class MyBeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第三步：在初始化之前执行的方法！");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步： 在初始化之后执行的方法！");
        return bean;
    }
}
