package com.learn.seata.at.business.service;

import com.alibaba.fastjson.JSONObject;
import com.learn.seata.at.dto.BusinessDTO;
import com.learn.seata.at.response.ObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


/**
 * @author yujiaqi
 * @date 2020-03-15 20:49
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BusinessServiceTest {

    @Autowired
    private BusinessService businessService;

    @Test
    public void handleBusinessTest(){
        BusinessDTO businessDTO =new BusinessDTO();
        businessDTO.setCommodityCode("C201901140001");
        businessDTO.setUserId("1");
        businessDTO.setCount(1);
        businessDTO.setName("水杯");
        businessDTO.setAmount(new BigDecimal("100"));
        ObjectResponse response = businessService.handleBusiness(businessDTO,false);
        log.info("response,{}", JSONObject.toJSONString(response));
    }
}
