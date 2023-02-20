package com.honor.springboot.controller;

import com.honor.springboot.constant.BaseConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * com.honor.springboot.controller
 *
 * @author honor-ljp
 * 2023/1/10 11:29
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    RedisTemplate redisTemplate;

    @GetMapping("/uriPv")
    public Map uriPv() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        return hashOperations.entries(BaseConstant.REQUEST_URI_PV);
    }
}
