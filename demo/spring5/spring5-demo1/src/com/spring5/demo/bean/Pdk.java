package com.spring5.demo.bean;

import com.spring5.demo.service.StudentService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

import java.util.List;

/**
 * com.spring5.demo.bean
 *
 * @author lijianpeng@huice.com
 * 2022/12/26 23:22
 */
public class Pdk implements FactoryBean<StudentService> {
    @Override
    public StudentService getObject() throws Exception {
        StudentService studentService = new StudentService();
        studentService.setList(List.of("超哥", "哈喽"));
        System.out.println("studentService.toString() = " + studentService.toString());
        return studentService;
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("类型");
        return null;
    }

    @Override
    public boolean isSingleton() {
        System.out.println("是否是单例");
        return false;
    }
}
