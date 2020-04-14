package com.mario.cloud.controller;

import com.mario.cloud.service.HystrixFeignPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
 * @author：ZXZ
 * @version 2020/3/10
 */
@RestController
@RequestMapping("hystrix")
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_timeOut_Global", commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "10000")})
public class HystrixFeignOrderController {
    @Autowired
    private HystrixFeignPaymentService hystrixFeignPaymentService;
    @HystrixCommand
    @GetMapping("/consumer/payment/ok")
    public String paymentInfo_Ok(){
        return hystrixFeignPaymentService.paymentInfo_Ok();
    }


   /* @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "10000")})*/
   //@HystrixCommand
    @GetMapping("/consumer/payment/timeout")
    public String paymentInfo_timeOut(){
        return hystrixFeignPaymentService.paymentInfo_timeOut();
    }

    public String paymentInfo_timeOutHandler(){
        return "线程池： "+Thread.currentThread().getName()+new Date() +"8007出错！客户端90等不及了... fallback";
    }
    //全局fallback
    public String paymentInfo_timeOut_Global(){
        return new  Date()+"Global 异常处理信息，请稍后重试!";
    }


}
