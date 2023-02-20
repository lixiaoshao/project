package com.spring5.demo.autowire;

import org.springframework.stereotype.Service;

/**
 * com.spring5.demo.autowire
 *
 * @author lijianpeng@huice.com  员工类
 * 2022/12/27 10:28
 */
@Service
public class Emp {
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
