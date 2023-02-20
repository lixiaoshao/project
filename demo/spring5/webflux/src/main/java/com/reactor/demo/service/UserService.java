package com.reactor.demo.service;

import com.reactor.demo.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * com.reactor.demo.service
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 19:55
 */
public interface UserService {
    // 根据ID查询用户
    Mono<User> getUserById(int id);
    // 查询所有用户
    Flux<User> getAllUser();
    // 添加用户
    Mono<Void> saveUserInfo(Mono<User> user);
}
