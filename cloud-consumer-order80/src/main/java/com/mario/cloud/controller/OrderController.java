package com.mario.cloud.controller;


import com.mario.commons.entity.CommonResult;
import com.mario.commons.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/*
 * @author：ZXZ
 * @version 2020/3/7
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController {
    //public static final String  PAYMENT_URL="http://127.0.0.1:8001/";  //单机版
    public static final String  PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE/";//通过微服务名进行访问
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"api/save",payment, CommonResult.class);
    }
    @GetMapping("/selectById")
    public CommonResult<Payment> selectById(@RequestParam(value = "id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"api/selectById?id="+id,CommonResult.class);
    }
}
