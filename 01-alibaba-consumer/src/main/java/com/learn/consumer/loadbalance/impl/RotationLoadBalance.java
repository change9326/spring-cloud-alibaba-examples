package com.learn.consumer.loadbalance.impl;

import com.learn.consumer.loadbalance.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yujiaqi
 * @date 2020-03-08 17:17
 * @description
 */
@Component
public class RotationLoadBalance implements LoadBalance {

    /**
     * 从0开始计数
     */
    private AtomicInteger atomicInteger=new  AtomicInteger(0);

    @Override
    public ServiceInstance selectServiceInstance(List<ServiceInstance> instanceList) {
        int index = atomicInteger.incrementAndGet() % instanceList.size();
        return instanceList.get(index);
    }

}
