package com.liouxb.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liouwb
 */
@Configuration
public class RestTemplateConfig {
    /**
     * ribbon负载均衡配置类IRule
     * RoundRobinRule 默认的 轮询
     * RandomRule随机
     * WeightedResponseTimeRule 权重
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
