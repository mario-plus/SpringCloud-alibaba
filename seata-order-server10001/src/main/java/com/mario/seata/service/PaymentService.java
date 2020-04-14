package com.mario.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@Component
@FeignClient(value = "seata-payment-server10000")
public interface PaymentService {
    @GetMapping("/updatePayment")
    void update(@RequestParam("userId") Integer userId, @RequestParam("money") Integer money);
}
