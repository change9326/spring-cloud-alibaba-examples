package com.learn.seata.at.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.seata.at.dto.CommodityDTO;
import com.learn.seata.at.response.ObjectResponse;
import com.learn.seata.at.storage.entity.Storage;

/**
 * @author yujiaqi
 * @date 2020-03-15 20:42
 * @description
 */
public interface IStorageService extends IService<Storage> {
    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}
