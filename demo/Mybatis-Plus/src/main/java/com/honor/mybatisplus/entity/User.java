package com.honor.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * com.honor.mybatisplus.entity
 *
 * @author honor-ljp
 * 2022/12/30 19:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("mybatis_plus_user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Byte isDel;
    @Version
    private Integer version;
}
