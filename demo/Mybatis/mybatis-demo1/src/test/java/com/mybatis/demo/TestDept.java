package com.mybatis.demo;


import com.mybatis.demo.entity.Dept;
import com.mybatis.demo.mapper.DeptMapper;
import com.mybatis.demo.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * com.mybatis.demo
 *
 * @author honor-ljp
 * 2022/12/29 20:32
 */
public class TestDept {
    @Test
    public void testGetDept() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptInfo = mapper.getDeptInfo(2);
        System.out.println("deptInfo = " + deptInfo);
    }

    @Test
    public void collectionGetDeptInfo() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptInfo = mapper.collectionGetDeptInfo(2);
        System.out.println("deptInfo = " + deptInfo);
    }
    @Test
    public void getDeptInfoRelEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptInfo = mapper.getDeptInfoRelEmp(2);
        System.out.println("deptInfo.getDeptName() = " + deptInfo.getDeptName());
        System.out.println("---------------------------------------------------");
        System.out.println("deptInfo = " + deptInfo);
    }

}
