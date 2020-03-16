package com.learn.seata.at.account.service;

import com.alibaba.fastjson.JSONObject;
import com.learn.seata.at.account.service.impl.AccountServiceImpl;
import com.learn.seata.at.dto.AccountDTO;
import com.learn.seata.at.response.ObjectResponse;
import com.learn.seata.at.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author yujiaqi
 * @date 2020-03-15 20:49
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AccountServiceTest {
    @Resource
    AccountServiceImpl accountService;

    @Test
    public void decreaseAccountTest(){
        AccountDTO accountDTO=new AccountDTO();
        accountDTO.setId(1);
        accountDTO.setUserId("1");
        accountDTO.setAmount(new BigDecimal("100"));

        ObjectResponse response = accountService.decreaseAccount(accountDTO);
        log.info("response={}", JSONObject.toJSONString(response));
    }
}
