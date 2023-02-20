package com.honor.mybatisplus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.honor.mybatisplus.entity.Emp;

/**
* @Entity com.honor.mybatisplus.entity.Emp
*/
public interface EmpMapper extends BaseMapper<Emp> {

    int insertAllData(Emp emp);

    List<Emp> selectAllByDeptIdAndAgeContaining(@Param("deptId") Integer deptId, @Param("age") Integer age);

    int updateAgeById(@Param("age") Integer age, @Param("id") Integer id);

    int deleteByIdAndDeptId(@Param("id") Integer id, @Param("deptId") Integer deptId);
}
