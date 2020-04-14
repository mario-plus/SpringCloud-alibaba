package com.mario.nacos.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author：ZXZ
 * @version 2020/3/12
 */
@RestController
@RefreshScope //支持nacos的动态刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;
    @Value("${config.name}")
    private String configName;
    @Value("${config.password}")
    private String configPsw;

    @GetMapping("/config/info")
    public String getConfigInfo(){

        return "info:"+configInfo+"\n"+"   name:"+configName+"\n"+"   password:"+configPsw;
    }
}
