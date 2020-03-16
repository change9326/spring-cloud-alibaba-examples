package com.learn.seata.at.storage.dubbo;

import com.learn.seata.at.dto.CommodityDTO;
import com.learn.seata.at.response.ObjectResponse;
import com.learn.seata.at.service.StorageService;
import com.learn.seata.at.storage.service.IStorageService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yujiaqi
 * @date 2020-03-16 15:26
 * @description
 */
@Slf4j
@Service(version = "1.0.0", timeout = 3000)
public class StorageDubboServiceImpl implements StorageService {

    @Autowired
    private IStorageService storageService;
    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        log.info("全局事务id ：{}" , RootContext.getXID());
        return storageService.decreaseStorage(commodityDTO);
    }
}
