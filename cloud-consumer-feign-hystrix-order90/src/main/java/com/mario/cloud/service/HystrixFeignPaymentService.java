package com.mario.cloud.service;

import com.mario.cloud.service.fallbackImpl.HystrixFeignPaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @author：ZXZ
 * @version 2020/3/10
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = HystrixFeignPaymentServiceImpl.class)
public interface HystrixFeignPaymentService {
    @GetMapping("/hystrix/payment/ok")
    public String paymentInfo_Ok();

    @GetMapping("/hystrix/payment/timeout")
    public String paymentInfo_timeOut();
}
