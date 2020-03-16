package com.learn.seata.at.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yujiaqi
 * @date 2020-03-15 15:51
 * @description
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @GetMapping("/hello")
    public String hello(){
        return "account-service";
    }
}
