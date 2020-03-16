package com.learn.seata.at.order.dubbo;

import com.learn.seata.at.dto.OrderDTO;
import com.learn.seata.at.order.service.IOrderService;
import com.learn.seata.at.response.ObjectResponse;
import com.learn.seata.at.service.OrderService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yujiaqi
 * @date 2020-03-15 21:08
 * @description
 */
@Service(version = "1.0.0",timeout = 3000)
@Slf4j
public class OrderDubboServiceImpl implements OrderService {

    @Autowired
    private IOrderService orderService;

    @Override
    public ObjectResponse createOrder(OrderDTO orderDTO) {
        log.info("全局事务id ：{}",RootContext.getXID());
        return orderService.createOrder(orderDTO);
    }


}
