package com.learn.seata.at.business.service.impl;

import com.learn.seata.at.business.service.BusinessService;
import com.learn.seata.at.dto.BusinessDTO;
import com.learn.seata.at.dto.CommodityDTO;
import com.learn.seata.at.dto.OrderDTO;
import com.learn.seata.at.enums.RspStatusEnum;
import com.learn.seata.at.exception.DefaultException;
import com.learn.seata.at.response.ObjectResponse;
import com.learn.seata.at.service.OrderService;
import com.learn.seata.at.service.StorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author yujiaqi
 * @date 2020-03-16 15:31
 * @description: Dubbo业务发起方逻辑
 */
@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Reference(version = "1.0.0",check = false)
    private StorageService storageDubboService;

    @Reference(version = "1.0.0",check = false)
    private OrderService orderDubboService;


    /**
     * 处理业务逻辑
     *
     * @Param:
     * @Return:
     */
    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-seata-example")
    public ObjectResponse handleBusiness(BusinessDTO businessDTO,boolean flag) {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        ObjectResponse<Object> objectResponse = new ObjectResponse<>();
        //1、扣减库存
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
        commodityDTO.setCount(businessDTO.getCount());
        ObjectResponse storageResponse = storageDubboService.decreaseStorage(commodityDTO);
        //2、创建订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        ObjectResponse<OrderDTO> response = orderDubboService.createOrder(orderDTO);

        //打开注释测试事务发生异常后，全局回滚功能
        if (!flag) {
            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
        }

        if (storageResponse.getStatus() != 200 || response.getStatus() != 200) {
            throw new DefaultException(RspStatusEnum.FAIL);
        }

        objectResponse.setStatus(RspStatusEnum.SUCCESS.getCode());
        objectResponse.setMessage(RspStatusEnum.SUCCESS.getMessage());
        objectResponse.setData(response.getData());
        return objectResponse;
    }

}