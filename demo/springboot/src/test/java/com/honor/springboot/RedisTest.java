package com.honor.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * com.honor.springboot
 *
 * @author honor-ljp
 * 2023/1/10 11:18
 */
@SpringBootTest
public class RedisTest {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void test() {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("chaoshi", "1");
        String chaoshi = valueOperations.get("chaoshi");
        assertEquals("1", chaoshi);
    }
}
