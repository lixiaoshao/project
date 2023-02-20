package com.reactor.demo;

import com.reactor.demo.handler.UserHandler;
import com.reactor.demo.service.UserService;
import com.reactor.demo.service.impl.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * PACKAGE_NAME
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 21:19
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter end");
        System.in.read();
    }
    /**
     * 创建路由
     */
    public RouterFunction<ServerResponse> routing() {
        UserService userService = new UserServiceImpl();
        UserHandler userHandler = new UserHandler(userService);

        return route(
                GET("/users/{id}")
                    .and(accept(MediaType.APPLICATION_JSON)), userHandler::getUserById)
                .andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUsers);
    }

    /**
     * 创建服务器完成适配
     */
    public void createReactorServer() {
        RouterFunction<ServerResponse> routing = routing();
        HttpHandler httpHandler = toHttpHandler(routing);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer.create()
                .handle(adapter)
                .bindNow();
    }
}
