package com.learn.consumer.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author yujiaqi
 * @date 2020-03-08 17:16
 * @description
 */
public interface LoadBalance {

    ServiceInstance selectServiceInstance(List<ServiceInstance> instanceList);
}
