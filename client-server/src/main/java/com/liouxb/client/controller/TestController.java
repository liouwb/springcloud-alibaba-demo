package com.liouxb.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author liouwb
 */
@RestController
@RequestMapping("client")
public class TestController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder clientBuilder;

    @GetMapping(value = "get")
    public String get() {

        return "这是一个服务";
    }


    /**
     * 调用provider服务 restTemplate
     *
     * @return
     */
    @GetMapping(value = "restProvider")
    public String restProvider() {
        //Access through the combination of LoadBalanceClient and RestTemplate
        // 发现服务
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-server");
        // 格式化请求路径
        String path = String.format("http://%s:%s/provider/get", serviceInstance.getHost(), serviceInstance.getPort());

        System.out.println("请求路径：" + path);

        return restTemplate.getForObject(path, String.class);
    }


    /**
     * 调用provider服务 webClientProvider
     *
     * @return
     */
    @GetMapping(value = "webClientProvider")
    public String webClientProvider() {

        return clientBuilder
                .baseUrl("http://provider-server/provider/get")
                .build()
                .method(HttpMethod.GET)
                .retrieve()//请求结果的方法
                .bodyToMono(String.class)
                .block();
    }
}
