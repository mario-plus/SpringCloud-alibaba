package com.mario.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/*
 * @author：ZXZ
 * @version 2020/3/7
 */
@RestController
@Slf4j
@RequestMapping("/api")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/paymentzk")
    public String paymentzk(){
        return "springcloud with zookeeper"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
