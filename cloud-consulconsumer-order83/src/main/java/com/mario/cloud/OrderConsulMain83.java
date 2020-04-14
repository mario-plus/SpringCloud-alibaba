package com.mario.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * @author：ZXZ
 * @version 2020/3/9
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain83.class,args);
    }
}
