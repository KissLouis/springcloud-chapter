package com.louis.springcloud.zuul.server.config;

import com.louis.springcloud.zuul.server.filter.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Louis
 * @title: ZuulConfig
 * @projectName springcloud-chapter
 * @description: TODO
 * @date 2020/1/5 20:18
 */
@Configuration
public class ZuulConfig {

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }


}
