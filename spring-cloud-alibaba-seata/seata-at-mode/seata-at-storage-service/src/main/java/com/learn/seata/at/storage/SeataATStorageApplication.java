package com.learn.seata.at.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yujiaqi
 * @date 2020-03-15 15:44
 * @description
 */
@EnableDiscoveryClient
@MapperScan("com.learn.seata.at.storage.mapper")
@SpringBootApplication
public class SeataATStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataATStorageApplication.class, args);
    }
}
