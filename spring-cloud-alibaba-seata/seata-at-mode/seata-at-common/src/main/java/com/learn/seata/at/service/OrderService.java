package com.learn.seata.at.service;

import com.learn.seata.at.dto.OrderDTO;
import com.learn.seata.at.response.ObjectResponse;

/**
 * @author yujiaqi
 * @date 2020-03-16 14:34
 * @description
 */
public interface OrderService {
    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}
