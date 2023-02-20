package com.honor.springboot.controller;

import com.honor.springboot.entity.Emp;
import com.honor.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

/**
 * com.honor.springboot.controller
 *
 * @author honor-ljp
 * 2023/1/9 23:07
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {
    @Autowired
    EmpService empService;

    @RequestMapping("/getEmpById/{id}")
    public Emp getEmpById(@PathVariable Integer id) {
        return empService.getEmp(id);
    }


    @PostMapping("/emp/insert")
    public Emp getEmpById(@RequestBody Emp emp) {
        empService.insert(emp);
        return emp;
    }
}
