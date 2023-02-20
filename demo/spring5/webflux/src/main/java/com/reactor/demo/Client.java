package com.reactor.demo;

import com.reactor.demo.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * com.reactor.demo
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 21:19
 */
public class Client {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:60360");
        User user = webClient.get().uri("/users/{id}", 1)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        System.out.println("user = " + user);

    }
}
