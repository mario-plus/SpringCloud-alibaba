package com.mario.cloud2020.controller;

import com.mario.cloud2020.entity.Payment;
import com.mario.cloud2020.rest.PaymentService;
import com.mario.commons.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * @author：ZXZ
 * @version 2020/3/7
 */
@RestController
@Slf4j
@RequestMapping("api")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;

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
        return new CommonResult(200,"通过8002查询成功"+serverPort,payment);
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

    @GetMapping("/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();//服务
        for (String element:services) {
            log.info("*********element********"+element);
        }
       List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");//指定服务的实例
        for (ServiceInstance instance:instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
