package com.mario.cloud2020.controller;

import com.mario.cloud2020.entity.Payment;
import com.mario.cloud2020.rest.PaymentService;
import com.mario.commons.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/*
 * @author：ZXZ
 * @version 2020/3/7
 */
@RestController
@RequestMapping("api")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;      //便于区分具体服务

    @PostMapping("/save")
    public CommonResult create(@RequestBody Payment payment){
       Payment getPayment= paymentService.save(payment);
        return new CommonResult(200,"插入数据成功"+serverPort,getPayment);
    }
    @GetMapping("/selectById")
    public CommonResult selectById(@RequestParam(value = "id") Integer id){
        Payment payment = paymentService.getById(id);
        return new CommonResult(200,"通过8001查询成功"+serverPort,payment);
    }
    @GetMapping("/timeout")
    public String controllTimeout(){
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }

}
