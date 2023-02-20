package com.honor.springboot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.honor.springboot.entity
 *
 * @author honor-ljp
 * 2022/12/31 21:26
 */
@Data
@ConfigurationProperties(prefix = "user")
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;
    // 员工属于某个公司是固定的，使用文件配置直接绑定
    private String company;

    private List<UserRole> userRole;

    @Data
    public static class UserRole {
        private String name;
    }
}
