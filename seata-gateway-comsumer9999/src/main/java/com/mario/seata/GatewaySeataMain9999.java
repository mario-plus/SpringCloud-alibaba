package com.mario.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * @author：ZXZ
 * @version 2020/3/16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySeataMain9999 {
    public static void main(String[] args) {
        SpringApplication.run(GatewaySeataMain9999.class,args);
    }
}
