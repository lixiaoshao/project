package com.mybatis.demo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.demo.entity.Emp;
import com.mybatis.demo.mapper.EmpMapper;
import com.mybatis.demo.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * com.mybatis.demo
 *
 * @author honor-ljp
 * 2022/12/30 15:01
 */
public class TestPageHelper {
    @Test
    public void pageHelper() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp(null, "", 30, "", null);
        // 第一种方式
        Page<Object> objects = PageHelper.startPage(1, 2);
        List<Emp> emps = mapper.builderQuery(emp);
        // 第二种方式
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps, 2);
        System.out.println("empPageInfo = " + empPageInfo);
    }
}
