package com.spring5.demo.test;

import com.spring5.demo.User;
import com.spring5.demo.autowire.Emp;
import com.spring5.demo.bean.Pdk;
import com.spring5.demo.service.LifeCycle;
import com.spring5.demo.service.StudentService;
import com.spring5.demo.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * com.spring5.demo.test
 *
 * @author lijianpeng@huice.com
 * 2022/12/26 19:43
 */
public class TestUser {
    @Test
    public void test() {
        // 加载spring配置文件
        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");
        // 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println("user = " + user);
        user.add();
    }
    @Test
    public void userServiceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void studentServiceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        StudentService studentService = context.getBean("stu", StudentService.class);
        System.out.println("studentService.toString() = " + studentService.toString());
    }
    @Test
    public void chouquTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        StudentService studentService = context.getBean("stu", StudentService.class);
        System.out.println("studentService.toString() = " + studentService.toString());
    }
    @Test
    public void pdkTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        StudentService studentService = context.getBean("pdk", StudentService.class);
    }


    @Test
    public void lifeCycleTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        LifeCycle bean = context.getBean("lifeCycle", LifeCycle.class);
        System.out.println("第六步：已经拿到bean了：" + bean.getClass().getName());
        context.close();
    }
    @Test
    public void testAutoWire() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println("emp = " + emp);
    }
}
