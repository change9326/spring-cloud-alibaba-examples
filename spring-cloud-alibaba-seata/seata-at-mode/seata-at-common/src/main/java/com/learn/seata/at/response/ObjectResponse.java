package com.learn.seata.at.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yujiaqi
 * @date 2020-03-15 20:32
 * @description
 */
@Data
public class ObjectResponse<T> extends BaseResponse implements Serializable {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
