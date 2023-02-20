package com.reactor.demo.service.impl;

import com.reactor.demo.entity.User;
import com.reactor.demo.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * com.reactor.demo.service.impl
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 19:59
 */
@Service
public class UserServiceImpl implements UserService {

    private final Map<Integer, User> users = new HashMap<>();

    public UserServiceImpl() {
        this.users.put(1, new User("超哥", "男", 20));
        this.users.put(2, new User("超哥1", "男", 30));
        this.users.put(3, new User("超哥2", "女", 40));
    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> user) {
        return user.doOnNext(s -> {
            int id = this.users.size() + 1;
            this.users.put(id, s);
        }).thenEmpty(Mono.empty());
    }
}
