package com.mario.seata.service;

import com.mario.seata.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
public interface OrderService {
    //1.新建订单
    void create(Order order);
    //2.修改订单
    void update(Integer userId,Integer status);
}
