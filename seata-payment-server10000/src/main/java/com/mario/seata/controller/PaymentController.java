package com.mario.seata.controller;

import com.mario.seata.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @GetMapping("/updatePayment")
    public void update(@RequestParam("userId") Integer userId, @RequestParam("money") Integer money){
        paymentService.update(userId,money);
    }
}
