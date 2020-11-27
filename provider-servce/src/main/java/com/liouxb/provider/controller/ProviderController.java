package com.liouxb.provider.controller;

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
    public String get() {

        return "这是一个provider服务,服务端口:" + serverPort;
    }
}
