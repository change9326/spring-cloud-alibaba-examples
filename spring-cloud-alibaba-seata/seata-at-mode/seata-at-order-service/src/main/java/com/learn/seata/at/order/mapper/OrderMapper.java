package com.learn.seata.at.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.seata.at.order.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author yujiaqi
 * @date 2020-03-15 15:44
 * @description
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 创建订单
     * @Param:  order 订单信息
     * @Return:
     */
    void createOrder(@Param("order") Order order);
}