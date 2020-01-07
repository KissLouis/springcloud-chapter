package com.louis.springcloud.service.consumer.feign.controller;

import com.louis.springcloud.service.consumer.feign.service.EurekaFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Louis
 * @title: EurekaFeignController
 * @projectName springcloud-chapter
 * @description: TODO
 * @date 2020/1/5 16:39
 */
@RestController
public class EurekaFeignController {

    @Resource
    private EurekaFeignService eurekaFeignService;

    @RequestMapping("/info")
    public String feignInfo() {
        String message = eurekaFeignService.getInfo();
        return "获取到的信息:" + message;
    }

}
