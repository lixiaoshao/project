package com.honor.springboot.interceptor;

import com.honor.springboot.constant.BaseConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * com.honor.springboot.interceptor
 *
 * @author honor-ljp
 * 2023/1/10 11:26
 */
@Component
public class PathPvInterceptor implements HandlerInterceptor {
    @Resource
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.increment(BaseConstant.REQUEST_URI_PV, uri, 1);
        return true;
    }
}
