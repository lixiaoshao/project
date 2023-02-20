package com.honor.fly.controller;

import com.honor.fly.entity.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/23 9:00
 */
@RestController
public class IndexController {

    @Autowired
    @Qualifier("dataSourceEntity")
    DataSource dataSource;

    @RequestMapping("/datasource")
    public DataSource dataSource() {
        return dataSource;
    }

    @RequestMapping("/datasource/other")
    public DataSource dataSourceOther() {
        return new DataSource();
    }
}
