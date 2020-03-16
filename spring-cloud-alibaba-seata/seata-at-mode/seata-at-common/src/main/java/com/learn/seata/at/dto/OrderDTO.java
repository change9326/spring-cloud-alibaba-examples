package com.learn.seata.at.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author yujiaqi
 * @date 2020-03-16 13:47
 * @description
 */
@Data
public class OrderDTO implements Serializable {

    private String orderNo;

    private String userId;

    private String commodityCode;

    private Integer orderCount;

    private BigDecimal orderAmount;
}
