package com.honor.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.honor.mybatisplus.entity.User;
import com.honor.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * com.honor.mybatisplus
 *
 * @author honor-ljp
 * 2022/12/30 22:56
 */
@SpringBootTest
public class UserWrapperTest {
    @Autowired
    UserService userService;

    /**
     * 组装查询条件
     */
    @Test
    public void queryWrapperTest() {
        // SELECT id,name,age,email FROM mybatis_plus_user WHERE (name LIKE ? AND age > ?)
        // 查询用户中包含“王”的并且年龄大于20的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "五")
                .gt("age", 20);
        List<User> list = userService.list(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * 组装排序条件
     */
    @Test
    public void queryWrapperOrderTest() {
        // 所有用户信息按照age倒叙后再按照id升序
        //SELECT id,name,age,email FROM mybatis_plus_user ORDER BY age DESC,id ASC
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderBy(true, false, "age")
                .orderBy(true, true, "id");
        List<User> list = userService.list(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * 组装删除条件
     */
    @Test
    public void queryWrapperDelTest() {
        // 删除用户中包含“王”的并且年龄大于20的用户信息 使用假删除（注解：@TableLogic）
        // UPDATE mybatis_plus_user SET is_del=1 WHERE is_del=0 AND (name LIKE ? AND age > ?)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "王")
                .gt("age", 20);
        boolean remove = userService.remove(wrapper);
        System.out.println("remove = " + remove);
    }

    /**
     * 使用queryWrapper修改功能
     */
    @Test
    public void queryWrapperUpdateTest() {
        // 将用户中包含”王“的用户名且年龄大于20 或 邮箱为NULL的修改
        // UPDATE mybatis_plus_user SET name=?, age=?, email=? WHERE is_del=0 AND (name LIKE ? AND age > ? OR email IS NULL)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "王")
                .gt("age", 20)
                .or()
                .isNull("email");
        User user = new User(null, "赵六" , 11, "zhaoliu@163.com", (byte)0, 0);
        boolean update = userService.update(user, wrapper);
        System.out.println("update = " + update);
    }

    /**
     * 条件优先级
     */
    @Test
    public void queryWrapperUpdateTwoTest() {
        // 将用户中包含”王“的用户名且 （年龄大于20 或 邮箱为NULL的修改）
        //SELECT id,name,age,email,is_del FROM mybatis_plus_user WHERE is_del=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "王")
                .and(a ->
                    a.gt("age", 20)
                            .or()
                            .isNull("email")
                );
        List<Map<String, Object>> maps = userService.listMaps(wrapper);
        maps.forEach(System.out::println);
    }

    /**
     * 组装select查询部分字段
     */
    @Test
    public void selectFewData() {
        // 查询部分字段数据
        /*SELECT name,age FROM mybatis_plus_user WHERE is_del=0*/
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name", "age");
        List<User> list = userService.list(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * 子查询
     */
    @Test
    public void subQuery() {
        // 子查询， 查询id小于10的用户信息
        // SELECT id,name,age,email,is_del FROM mybatis_plus_user WHERE is_del=0 AND (id IN (select id from mybatis_plus_user where id < 10))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select id from mybatis_plus_user where id < 10");
        List<User> list = userService.list(wrapper);
        list.forEach(System.out::println);
    }
    @Test
    public void updateWrapperTest() {
        // 将用户中包含”王“的用户名且 （年龄大于20 或 邮箱为NULL的修改） 修改为老六  用condition组装条件
        // UPDATE mybatis_plus_user SET name=? WHERE is_del=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.likeRight(true, "name", "王")
                .and(s ->
                        s.gt("age", 20)
                        .or()
                        .isNull("email")
                )
                .set("name", "老六");
        boolean update = userService.update(updateWrapper);
        System.out.println("update = " + update);
    }
    @Test
    public void lambdaQueryWrapperTest() {
        // 查询用户中包含”王“的用户名且 （年龄大于20 或 邮箱为NULL的修改）
        // SELECT id,name,age,email,is_del FROM mybatis_plus_user WHERE is_del=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.likeRight(true, User::getName, "王")
                .and(s ->
                        s.gt(User::getAge, 20)
                                .or()
                                .isNull(User::getEmail)
                );
        List<User> list = userService.list(queryWrapper);
        list.forEach(System.out::println);
    }
    @Test
    public void lambdaUpdateWrapperTest() {
        // 将用户中包含”王“的用户名且 （年龄大于20 或 邮箱为NULL的修改）
        // UPDATE mybatis_plus_user SET name=? WHERE is_del=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.likeRight(true, User::getName, "王")
                .and(s ->
                        s.gt(User::getAge, 20)
                                .or()
                                .isNull(User::getEmail)
                ).set(User::getName, "老六");
        boolean update = userService.update(updateWrapper);
        System.out.println("update = " + update);
    }
}
