package com.honor.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * com.honor.mybatisplus
 *
 * @author honor-ljp
 * 2022/12/31 12:16
 */
@SpringBootTest
public class FastAutoGeneratorTest {
    @Test
    public void test() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3308/mybatis-plus?characterEncoding=utf-8&useSSL=false",
                "root",
                "123456")
                .globalConfig(builder -> {
                    builder.author("honor-ljp") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("F:\\Java\\project\\demo\\Mybatis-Plus-Generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.honor") // 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapper, "F:\\Java\\project\\demo\\Mybatis-Plus-Generator")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("mybatis_plus_salary") // 设置需要生成的表名
                            .addTablePrefix("mybatis_plus_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
