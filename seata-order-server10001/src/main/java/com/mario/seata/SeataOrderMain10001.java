package com.mario.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrderMain10001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain10001.class,args);
    }
}
