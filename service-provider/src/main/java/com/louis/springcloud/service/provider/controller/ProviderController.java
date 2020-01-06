package com.louis.springcloud.service.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @title: ProviderController
 * @projectName springcloud-chapter
 * @description: TODO
 * @date 2020/1/2 20:31
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("info")
    public String info() {
        return "这是spring-cloud-service-provider\t port:" + port;
    }


    //返回一个列表
    @GetMapping("list")
    public Flux<Integer> list() {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(22);
        list.add(75);
        list.add(93);
        Flux<Integer> userFlux = Flux.fromIterable(list);
        return userFlux;
    }
}
