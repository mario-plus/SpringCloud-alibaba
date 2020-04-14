package com.mario.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.mario.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*
 * @author：ZXZ
 * @version 2020/3/10
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_Ok() {
        return "线程池： "+Thread.currentThread().getName()+" hahahahhahha"+"...paymentInfo_Ok";
    }
    //============服务降级
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "4000")
    })
    public String paymentInfo_timeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+"... 正常延迟时间"+new Date();
    }
    public String paymentInfo_timeOutHandler(){
        return "线程池： "+Thread.currentThread().getName()+"8007出错！... fallback别怕，我来兜底了!";
    }

    //===========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "15000"),//时间窗口期10s
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸60%
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if (id<100){
            log.error("id 不符合规范！");
            throw new RuntimeException("**********id不能小于100");
        }
        String serialNumber = IdUtil.simpleUUID();//等价于UUID.randomUUID().toString()
        return Thread.currentThread().getName()+"\t"+"成功，流水号："+serialNumber;
    }
    //服务降级函数
    public String paymentCircuitBreak_fallback(@PathVariable("id") Integer id){
        return "id 不能小于100，请稍后重试,fallback"+id;
    }
}
