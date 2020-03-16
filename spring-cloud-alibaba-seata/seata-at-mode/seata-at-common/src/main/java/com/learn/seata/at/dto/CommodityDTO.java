package com.learn.seata.at.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yujiaqi
 * @date 2020-03-16 13:47
 * @description
 */
@Data
public class CommodityDTO implements Serializable {

    private Integer id;

    private String commodityCode;

    private String name;

    private Integer count;
}
