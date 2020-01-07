package com.louis.springcloud.service.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Louis
 * @title: EurekaFeignService
 * @projectName springcloud-chapter
 * @description: TODO 服务消费者
 * @date 2020/1/5 16:38
 */
@FeignClient(value = "SPRING-CLOUD-SERVICE-PROVIDER", fallback = EurekaFeignServiceFailure.class) // 调用的服务的名称
public interface EurekaFeignService {

    @RequestMapping(value = "/info")
    String getInfo();

}
