package com.mario.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
 * @author：ZXZ
 * @version 2020/3/9
 */
@RestController
@Slf4j
public class OrderConsulController {
    private static final String INVOKE_URL="http://consul-provider-payment";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consul/consumer/getInfo")
    public String paymentInfo(){
        String URL = INVOKE_URL+"/api/payment/consul";
        log.info(URL);
        return  restTemplate.getForObject(URL,String.class);
    }
}
