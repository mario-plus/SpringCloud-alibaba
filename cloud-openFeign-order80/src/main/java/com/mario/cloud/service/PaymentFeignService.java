package com.mario.cloud.service;

/*
 * @author：ZXZ
 * @version 2020/3/9
 */

import com.mario.commons.entity.CommonResult;
import com.mario.commons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    @PostMapping("/api/save")
     CommonResult create(@RequestBody Payment payment);

    @GetMapping("/api/selectById")
     CommonResult selectById(@RequestParam(value = "id") Integer id);

    @GetMapping("/api/timeout")
    public String controllTimeout();
}
