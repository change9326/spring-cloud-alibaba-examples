package com.learn.seata.at.account.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author yujiaqi
 * @date 2020-03-15 15:44
 * @description
 */
@Data
public class Account implements Serializable {
    private Integer id;

    private String userId;

    private double amount;

    private static final long serialVersionUID = 1L;
}