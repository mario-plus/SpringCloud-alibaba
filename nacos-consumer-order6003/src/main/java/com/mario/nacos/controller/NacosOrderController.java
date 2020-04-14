package com.mario.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
 * @author：ZXZ
 * @version 2020/3/11
 */
@RestController
public class NacosOrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string){
        return restTemplate.getForObject(serverURL+"/echo/"+string,String.class);
    }
}
