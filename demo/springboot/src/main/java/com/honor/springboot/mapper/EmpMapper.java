package com.honor.springboot.mapper;

import com.honor.springboot.entity.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * com.honor.springboot.mapper
 *
 * @author honor-ljp
 * 2023/1/9 23:00
 */
// 这个注解可以没有，应用入口开启了mapper组件扫描，但是idea @AutoWired会标红
@Repository
public interface EmpMapper {
    Emp getEmp(Integer id);

    @Insert("INSERT INTO `mybatis_emp` (`emp_name`, `age`, `sex`, `dept_id`) VALUES (#{empName}, #{age}, #{sex}, #{deptId});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Emp emp);
}
