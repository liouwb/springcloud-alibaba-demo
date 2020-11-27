package com.liouxb.client.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liouwb
 */
@Configuration
public class RibbonRuleConfig {

    /**
     * 自定义负载均衡算法
     * ribbon负载均衡配置类IRule
     * RoundRobinRule 默认的 轮询
     * RandomRule随机
     * WeightedResponseTimeRule 权重
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
