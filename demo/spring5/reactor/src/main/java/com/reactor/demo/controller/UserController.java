package com.reactor.demo.controller;

import com.reactor.demo.entity.User;
import com.reactor.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * com.reactor.demo.controller
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 20:12
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @GetMapping("/users")
    public Flux<User> getUserById() {
        return userService.getAllUser();
    }
    @PostMapping("/save")
    public Mono<Void> saveUserInfo(@RequestBody User user) {
        Mono<User> monoUsers = Mono.just(user);
        return userService.saveUserInfo(monoUsers);
    }
}
