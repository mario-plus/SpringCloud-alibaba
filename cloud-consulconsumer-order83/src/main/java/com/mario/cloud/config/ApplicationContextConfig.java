package com.mario.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 * @author：ZXZ
 * @version 2020/3/7
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    public IRule myRule(){
       // return new RandomRule();//轮询
        return new RoundRobinRule();//随机
    }
    @Bean
    @LoadBalanced  //默认的负载均衡机制，赋予了restTemplate具有负载均衡的能力（轮询）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
