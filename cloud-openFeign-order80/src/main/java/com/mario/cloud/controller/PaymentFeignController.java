package com.mario.cloud.controller;

import com.mario.cloud.service.PaymentFeignService;
import com.mario.commons.entity.CommonResult;
import com.mario.commons.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * @author：ZXZ
 * @version 2020/3/9
 */
@RestController
@Slf4j
@RequestMapping("/openFeignConsumer")
public class PaymentFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @PostMapping("/save")
    public CommonResult create(@RequestBody Payment payment){
        return paymentFeignService.create(payment);
    }

    @GetMapping("/selectById")
    public CommonResult selectById(@RequestParam(value = "id") Integer id){
       return paymentFeignService.selectById(id);
    }
    @GetMapping("/timeout")
    public String timeout(){
        return paymentFeignService.controllTimeout();
    }
}
