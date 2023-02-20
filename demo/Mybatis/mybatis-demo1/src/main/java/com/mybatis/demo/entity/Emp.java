package com.mybatis.demo.entity;

/**
 * com.mybatis.demo.entity
 *
 * @author honor-ljp
 * 2022/12/29 20:13
 */
public class Emp {
    private Integer id;
    private String empName;
    private Integer age;
    private String sex;
    private Integer deptId;
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", deptId=" + deptId +
                ", dept=" + dept +
                '}';
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Emp() {
    }

    public Emp(Integer id, String empName, Integer age, String sex, Integer deptId) {
        this.id = id;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.deptId = deptId;
    }
}
