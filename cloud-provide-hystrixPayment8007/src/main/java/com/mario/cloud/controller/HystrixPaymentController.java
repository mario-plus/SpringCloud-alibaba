package com.mario.cloud.controller;

import com.mario.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author：ZXZ
 * @version 2020/3/10
 */
@RestController
@RequestMapping("hystrix")
public class HystrixPaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/ok")
    public String paymentInfo_Ok(){
        return paymentService.paymentInfo_Ok();
    }


    @GetMapping("/payment/timeout")
    public String paymentInfo_timeOut(){
        return paymentService.paymentInfo_timeOut();
    }

    //=======服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
