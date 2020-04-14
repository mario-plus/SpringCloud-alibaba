package com.mario.seata.controller;

import com.mario.seata.domain.Order;
import com.mario.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order order){
        orderService.create(order);
        orderService.update(order.getUserId(),order.getStatus());
    }
}
