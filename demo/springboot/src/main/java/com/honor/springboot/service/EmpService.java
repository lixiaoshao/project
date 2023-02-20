package com.honor.springboot.service;

import com.honor.springboot.entity.Emp;
import com.honor.springboot.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.honor.springboot.service
 *
 * @author honor-ljp
 * 2023/1/9 23:09
 */
@Service
public class EmpService {
    @Autowired
    EmpMapper empMapper;

    public Emp getEmp(Integer id) {
        return empMapper.getEmp(id);
    }

    public void insert(Emp emp) {
        empMapper.insert(emp);
    }
}
