package com.mario.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @author：ZXZ
 * @version 2020/3/9
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignMain82 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain82.class,args);
    }
}
