package com.liouxb.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liouwb
 */
@RestController
@RequestMapping("provider")
public class ProviderController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "get")
    @SentinelResource(value = "get", blockHandler = "exceptionHandler", fallback = "fallbackFun")// value 原方法 blockHandler  异常处理 fallback 降级处理
    public String get() {

        return "这是一个provider服务,服务端口:" + serverPort;
    }

    public String fallbackFun() {

        return "@sentinel:" + serverPort;
    }

    public String exceptionHandler(){

        return "@sentinel exceptionHandler:" + serverPort;
    }
}
