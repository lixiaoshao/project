package com.honor.mybatisplus;

import com.honor.mybatisplus.entity.Salary;
import com.honor.mybatisplus.entity.User;
import com.honor.mybatisplus.service.ISalaryService;
import com.honor.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * com.honor.mybatisplus
 *
 * @author honor-ljp
 * 2022/12/31 13:50
 */
@SpringBootTest
public class DynamicDataSource {
    @Autowired
    UserService userService;
    @Autowired
    ISalaryService salaryService;
    @Test
    public void testDataSource() {
        User user = userService.getById(2);
        System.out.println("user = " + user);
        Salary salary = salaryService.getById(1);
        System.out.println("salary = " + salary);
    }
}
