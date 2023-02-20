package com.reactor.demo.reactor;

import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Flux;

import java.util.Arrays;

/**
 * com.reactor.demo.reactor
 *
 * @author lijianpeng@huice.com
 * 2022/12/28 18:50
 */
public class TestReactor {
    public static void main(String[] args) {
        Flux.just(1, 2, 3).subscribe(System.out::println);

        Integer[] arr = {1, 2, 3};
        Flux.fromArray(arr).subscribe(System.out::println);

        Flux.fromIterable(Arrays.asList(arr));

        Flux.fromStream(Arrays.asList(arr).stream());

        Flux.error(new Exception("error"));


    }
}
