package com.mybatis.demo.entity;

import java.math.BigDecimal;

public class Salary {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mybatis_salary.id
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mybatis_salary.emp_id
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    private Integer empId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mybatis_salary.salary
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    private BigDecimal salary;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mybatis_salary.level
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    private Integer level;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mybatis_salary.id
     *
     * @return the value of mybatis_salary.id
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mybatis_salary.id
     *
     * @param id the value for mybatis_salary.id
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mybatis_salary.emp_id
     *
     * @return the value of mybatis_salary.emp_id
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mybatis_salary.emp_id
     *
     * @param empId the value for mybatis_salary.emp_id
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mybatis_salary.salary
     *
     * @return the value of mybatis_salary.salary
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mybatis_salary.salary
     *
     * @param salary the value for mybatis_salary.salary
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mybatis_salary.level
     *
     * @return the value of mybatis_salary.level
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mybatis_salary.level
     *
     * @param level the value for mybatis_salary.level
     *
     * @mbggenerated Fri Dec 30 14:20:23 CST 2022
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}