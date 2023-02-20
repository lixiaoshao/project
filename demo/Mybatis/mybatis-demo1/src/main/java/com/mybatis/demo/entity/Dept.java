package com.mybatis.demo.entity;

import java.util.List;

/**
 * com.mybatis.demo.entity
 *
 * @author honor-ljp
 * 2022/12/29 20:14
 */
public class Dept {

    private Integer deptId;
    private String deptName;
    private List<Emp> emps;

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Dept() {
    }

    public Dept(Integer id, String deptName) {
        this.deptId = id;
        this.deptName = deptName;
    }
}
