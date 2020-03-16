package com.learn.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yujiaqi
 * @date 2020-03-08 00:15
 * @description
 */
@Configuration
public class RestTemplateConfig {

    // 基于ribbon开启客户端负载均衡
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
