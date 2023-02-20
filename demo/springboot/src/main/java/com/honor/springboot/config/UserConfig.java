package com.honor.springboot.config;

import com.honor.springboot.entity.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * com.honor.springboot.config
 *
 * @author honor-ljp
 * 2022/12/31 21:25
 */

/**
 *
 * 配置类里边使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 配置类也是一个组件，eg： userConfig
 * proxyBeanMethods 默认true，表示代理对象调用方法，SpringBoot总会检查这个组件是否在容器中，如果有：返回容器实例
 * 这就引申出SpringBoot在底层是Full(全配置) Lite（轻量级配置）
 * 解决场景：proxyBeanMethods：true 解决组件依赖问题
 */
@Import({User.class})
@Configuration(proxyBeanMethods = true)
@EnableConfigurationProperties(User.class)
// 告诉SpringBoot这是一个配置类，相当于配置文件
public class UserConfig {
    /**
     * 外部无论调用多少次这个方法，获取到的都是注册到容器中的组件实例
     * @return
     */
    @Bean  // 给容器添加组件，以方法名作为组件ID，返回类型作为组件类型，返回值，作为容器在组件中的实例
    public User getUserBean() {
        return new User();
    }
    @Bean("zhangsan")
    @Conditional(UserCondition.class)
    public User getZs() {
        String name = getClass().getName();
        System.out.println("name = " + name);
        User user = new User();
        user.setUserName("张三");
        return user;
    }

    public static class UserCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true;
        }
    }
}
