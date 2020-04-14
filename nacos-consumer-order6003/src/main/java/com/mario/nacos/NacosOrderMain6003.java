package com.mario.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @author：ZXZ
 * @version 2020/3/11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosOrderMain6003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain6003.class,args);
    }
}
