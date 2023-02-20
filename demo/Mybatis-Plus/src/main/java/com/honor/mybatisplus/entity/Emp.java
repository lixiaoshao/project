package com.honor.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName mybatis_emp
 */
@TableName(value ="mybatis_emp")
@Data
public class Emp implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String empName;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private Integer deptId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}