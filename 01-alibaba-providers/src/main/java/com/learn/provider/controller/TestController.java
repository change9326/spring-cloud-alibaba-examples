package com.learn.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yujiaqi
 * @date 2020-03-13 13:59
 * @description
 */
@RestController
public class TestController {
    @Value("${server.port}")
    private String serverPort;



    @SentinelResource(value = "echoResource",fallback = "helloFallback",blockHandler="exceptionHandler")
    @GetMapping(value = "/provider/{string}")
    public String echo(@PathVariable String string) {
            return serverPort +"---"+ string;
        }


    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String helloFallback(String string) {
        return String.format("Fallback %s", string);
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(String string, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "blockHandler, error occurred at " + string;
    }

}
