package com.learn.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yujiaqi
 * @date 2020-03-08 00:21
 * @description
 */
@RefreshScope
@RestController
public class ConfigTestController {


    @Value("${edianzu.companyName}")
    private String companyName;
    /**
     *
     * @return
     */
    @GetMapping(value = "/getCompanyName")
    public String getCompanyName() {
        return "companyName:"+companyName;
    }



}
