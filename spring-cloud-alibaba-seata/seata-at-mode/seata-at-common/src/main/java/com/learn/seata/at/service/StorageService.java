package com.learn.seata.at.service;

import com.learn.seata.at.dto.CommodityDTO;
import com.learn.seata.at.response.ObjectResponse;

/**
 * @author yujiaqi
 * @date 2020-03-16 15:21
 * @description
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}
