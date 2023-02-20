package com.mybatis.demo;

import com.mybatis.demo.entity.Salary;
import com.mybatis.demo.entity.SalaryExample;
import com.mybatis.demo.mapper.SalaryMapper;
import com.mybatis.demo.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * com.mybatis.demo
 *
 * @author honor-ljp
 * 2022/12/30 14:26
 */
public class TestMBG {
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);
        List<Salary> salaries = mapper.selectByExample(null);
        salaries.forEach(s -> System.out.println("salary = " + s.getSalary()));

        SalaryExample salaryExample = new SalaryExample();
        salaryExample.createCriteria().andSalaryBetween(new BigDecimal(10000), new BigDecimal(50000))
                .andEmpIdIsNotNull();
        List<Salary> salaries1 = mapper.selectByExample(salaryExample);
        salaries1.forEach(s -> System.out.println("salary = " + s.getSalary()));
    }
}
