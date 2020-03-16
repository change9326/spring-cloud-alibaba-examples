package com.learn.seata.at.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.seata.at.dto.CommodityDTO;
import com.learn.seata.at.enums.RspStatusEnum;
import com.learn.seata.at.response.ObjectResponse;
import com.learn.seata.at.storage.entity.Storage;
import com.learn.seata.at.storage.mapper.StorageMapper;
import com.learn.seata.at.storage.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yujiaqi
 * @date 2020-03-16 15:15
 * @description
 */
@Slf4j
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements IStorageService {

    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        int storage = baseMapper.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (storage > 0){
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
}
