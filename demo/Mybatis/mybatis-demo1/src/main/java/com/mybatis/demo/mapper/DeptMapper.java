package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * com.mybatis.demo.mapper
 *
 * @author honor-ljp
 * 2022/12/29 20:15
 */
public interface DeptMapper {
    Dept getDeptInfo(@Param("dept_id") Integer deptId);
    Dept collectionGetDeptInfo(@Param("deptId") Integer deptId);
    Dept getDeptInfoRelEmp(@Param("deptId") Integer deptId);
}
