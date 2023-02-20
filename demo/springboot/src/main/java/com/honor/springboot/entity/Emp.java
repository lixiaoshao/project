package com.honor.springboot.entity;

import lombok.Data;

/**
 * com.honor.springboot.entity
 *
 * @author honor-ljp
 * 2023/1/9 23:00
 */
@Data
public class Emp {
    private Integer id;
    private String empName;
    private Integer age;
    private String sex;
    private Integer deptId;
}
