package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * com.mybatis.demo.mapper
 *
 * @author honor-ljp
 * 2022/12/29 20:14
 */
public interface EmpMapper {
    List<Emp> getUserList(@Param("deptId") Integer deptId);
    Emp getRelUserInfo(@Param("id") Integer id);
    Emp getUserInfo(@Param("id") Integer id);
    List<Emp> builderQuery(Emp emp);
    List<Emp> builderQueryByArray(@Param("ids") Integer[] ids);
    void batchInsert(@Param("batchData") List<Emp> emps);
}
