package com.learn.seata.at.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author yujiaqi
 * @date 2020-03-15 16:56
 * @description
 */
@Data
public class AccountDTO implements Serializable {

    private Integer id;

    private String userId;

    private BigDecimal amount;

}
