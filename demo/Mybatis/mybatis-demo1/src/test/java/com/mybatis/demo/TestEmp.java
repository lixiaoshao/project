package com.mybatis.demo;

import com.mybatis.demo.entity.Emp;
import com.mybatis.demo.mapper.EmpMapper;
import com.mybatis.demo.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.mybatis.demo
 *
 * @author honor-ljp
 * 2022/12/29 21:44
 */
public class TestEmp {
    @Test
    public void testTwoCache() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
            List<Emp> userList = mapper1.getUserList(2);
            System.out.println("userList = " + userList);
            sqlSession1.close();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            EmpMapper mapper2 = sqlSession2.getMapper(EmpMapper.class);
            List<Emp> userList2 = mapper2.getUserList(2);
            System.out.println("userList2 = " + userList2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getUserList() {
        EmpMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmpMapper.class);
        List<Emp> userList = mapper.getUserList(2);
        userList.forEach(s -> System.out.println("s = " + s));
    }
    @Test
    public void getRelUserInfo() {
        EmpMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmpMapper.class);
        Emp userInfo = mapper.getRelUserInfo(1);
        System.out.println("userInfo = " + userInfo);
    }
    @Test
    public void getUserInfo() throws InterruptedException {
        EmpMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmpMapper.class);
        Emp userInfo = mapper.getUserInfo(1);
        System.out.println("userInfo = " + userInfo.getEmpName());
        Thread.sleep(3000);
        System.out.println("userInfo.getDept() = " + userInfo.getDept());
    }
    @Test
    public void builderQuery() {
        EmpMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmpMapper.class);
        Emp emp = new Emp(null, "", null, "", 2);
        List<Emp> result = mapper.builderQuery(emp);
        System.out.println("result = " + result);
    }
    @Test
    public void builderQueryByArray() {
        EmpMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmpMapper.class);
        List<Emp> result = mapper.builderQueryByArray(new Integer[] {1, 2, 3});
        System.out.println("result = " + result);
    }
    @Test
    public void batchInsert() {
        EmpMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmpMapper.class);
        Emp emp = new Emp(null, "张三1", 30, "男", 2);
        Emp emp1 = new Emp(null, "李四1", 30, "男", 2);
        Emp emp2 = new Emp(null, "王五1", 30, "男", 2);
        List<Emp> emps = Arrays.asList(emp, emp1, emp2);
        mapper.batchInsert(emps);
        System.out.println("成功");
    }
}
