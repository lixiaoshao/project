package com.reactor.demo.handler;

import com.reactor.demo.entity.User;
import com.reactor.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

/**
 * com.reactor.demo.handler
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 21:28
 */
public class UserHandler {

    private UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        Mono<User> monoUser = this.userService.getUserById(id);
        return monoUser.flatMap(s ->
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(fromValue(s))
                .switchIfEmpty(ServerResponse.notFound().build())
        );
    }

    public Mono<ServerResponse> getUsers(ServerRequest request) {
        Flux<User> allUser = this.userService.getAllUser();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(allUser, User.class);
    }
    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> user = request.bodyToMono(User.class);
        Mono<Void> voidMono = this.userService.saveUserInfo(user);
        return ServerResponse.ok().build(voidMono);
    }
}
