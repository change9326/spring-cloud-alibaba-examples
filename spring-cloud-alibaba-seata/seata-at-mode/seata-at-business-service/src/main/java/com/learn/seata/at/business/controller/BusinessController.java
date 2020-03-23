package com.learn.seata.at.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.seata.at.business.service.BusinessService;
import com.learn.seata.at.dto.BusinessDTO;
import com.learn.seata.at.response.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author yujiaqi
 * @date 2020-03-17 11:13
 * @description
 */
@RestController
@RequestMapping("business")
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @GetMapping("/handle")
    public String handle(){
        BusinessDTO businessDTO =new BusinessDTO();
        businessDTO.setCommodityCode("C201901140001");
        businessDTO.setUserId("1");
        businessDTO.setCount(1);
        businessDTO.setName("水杯");
        businessDTO.setAmount(new BigDecimal("100"));
        ObjectResponse response = businessService.handleBusiness(businessDTO,false
        );
        return JSONObject.toJSONString(response);
    }
}
