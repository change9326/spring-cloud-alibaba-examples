package com.learn.seata.at.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yujiaqi
 * @date 2020-03-16 15:37
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SeataATBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataATBusinessApplication.class, args);
    }
}
