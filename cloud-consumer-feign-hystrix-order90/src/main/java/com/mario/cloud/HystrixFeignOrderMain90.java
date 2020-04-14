package com.mario.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @author：ZXZ
 * @version 2020/3/10
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class HystrixFeignOrderMain90 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignOrderMain90.class,args);
    }
}
