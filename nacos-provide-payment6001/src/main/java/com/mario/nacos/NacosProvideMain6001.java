package com.mario.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * @author：ZXZ
 * @version 2020/3/11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvideMain6001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProvideMain6001.class,args);
    }
}
