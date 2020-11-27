package com.liouxb.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liouwb
 */
@RestController
@RequestMapping("client")
public class TestController {

    @GetMapping(value = "/get")
    public String get() {

        return "这是一个服务";
    }
}
