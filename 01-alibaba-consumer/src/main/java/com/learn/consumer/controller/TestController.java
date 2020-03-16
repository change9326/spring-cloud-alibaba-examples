package com.learn.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.learn.feign.api.service.EchoService;
import com.learn.consumer.loadbalance.LoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yujiaqi
 * @date 2020-03-08 00:21
 * @description
 */
@RestController
public class TestController {

    @Autowired
    DiscoveryClient discoveryClient;
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EchoService echoService;

    @Value("{server.port}")
    private String serverPort;

    @Autowired
    private LoadBalance loadBalance;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 基于Ribbon 实现本地复杂均衡
     * @param str
     * @return
     */
    @GetMapping(value = "/echo-rest/{str}")
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://service-provider01/echo/" + str, String.class);
    }
    @GetMapping(value = "/echo-feign/{str}")
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }

    @GetMapping(value = "getServiceInstance")
    public String getServiceInstance() {
        // 根据服务名称，从注册中心获取集群地址列表
        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider01");
        return JSONObject.toJSONString(instances);

    }

    @GetMapping(value = "selectServiceInstance")
    public String selectServiceInstance() {
        // 根据服务名称，从注册中心获取集群地址列表
        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider01");
        ServiceInstance serviceInstance = loadBalance.selectServiceInstance(instances);
        return JSONObject.toJSONString(serviceInstance);

    }


    /**
     * 根据 LoadBalancerClient 客户端镜像负载均衡
     * @return
     */
    @GetMapping(value = "/loadBalancerClient")
    public String loadBalanceClient() {
        ServiceInstance choose = loadBalancerClient.choose("service-provider01");
        return JSONObject.toJSONString(choose);
    }


}
