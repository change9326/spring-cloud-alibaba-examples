package com.learn.seata.at.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author yujiaqi
 * @date 2020-03-16 13:48
 * @description
 */
@Data
public class BusinessDTO implements Serializable {

    private String userId;

    private String commodityCode;

    private String name;

    private Integer count;

    private BigDecimal amount;

}
