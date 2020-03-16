package com.learn.seata.at.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yujiaqi
 * @date 2020-03-15 20:32
 * @description
 */
@Data
public class BaseResponse implements Serializable {

    private int status = 200;

    private String message;


}
