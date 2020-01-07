package com.louis.springcloud.service.consumer.feign.service;

import org.springframework.stereotype.Service;

/**
 * @author Louis
 * @title: EurekaFeignServiceFailure
 * @projectName springcloud-chapter
 * @description: TODO
 * @date 2020/1/5 17:10
 */
@Service
public class EurekaFeignServiceFailure implements EurekaFeignService {

    @Override
    public String getInfo() {
        String message = "网络繁忙，请稍后再试-_-。PS：服务消费者自己提供的信息";
        return message;
    }
}
