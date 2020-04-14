package com.mario.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataPaymentMain10000 {
    public static void main(String[] args) {
        SpringApplication.run(SeataPaymentMain10000.class,args);
    }
}
