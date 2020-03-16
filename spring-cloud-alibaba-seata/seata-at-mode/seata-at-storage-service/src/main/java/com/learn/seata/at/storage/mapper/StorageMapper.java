package com.learn.seata.at.storage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.seata.at.storage.entity.Storage;
import org.apache.ibatis.annotations.Param;

/**
 * @author yujiaqi
 * @date 2020-03-15 15:44
 * @description
 */
public interface StorageMapper extends BaseMapper<Storage> {
    /**
     * 扣减商品库存
     * @Param: commodityCode 商品code  count扣减数量
     * @Return:
     */
    int decreaseStorage(@Param("commodityCode") String commodityCode, @Param("count") Integer count);

}