package com.learn.seata.at.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.seata.at.dto.OrderDTO;
import com.learn.seata.at.order.entity.Order;
import com.learn.seata.at.response.ObjectResponse;

/**
 * @author yujiaqi
 * @date 2020-03-16 13:42
 * @description
 */
public interface IOrderService extends IService<Order> {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}
