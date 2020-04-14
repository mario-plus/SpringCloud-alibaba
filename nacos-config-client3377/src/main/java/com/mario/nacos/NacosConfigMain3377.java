package com.mario.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * @author：ZXZ
 * @version 2020/3/12
 */
@SpringBootApplication
@EnableDiscoveryClient

public class NacosConfigMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain3377.class,args);
    }
}
