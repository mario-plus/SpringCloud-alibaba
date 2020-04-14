package com.mario.seata.service.impl;

import com.mario.seata.domain.Order;
import com.mario.seata.repository.OrderReposity;
import com.mario.seata.service.OrderService;

import com.mario.seata.service.PaymentService;
import com.mario.seata.service.StockService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
   private OrderReposity orderReposity;
    @Autowired
    private StockService stockService;
    @Autowired
    private PaymentService paymentService;
    @Override
    //@GlobalTransactional(name = "fxp-create-order" , rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("=================>开始新建订单");
        orderReposity.save(order);
        log.info("=================>订单微服务开始调用库存微服务，做扣减操作");
        Integer productId = order.getProductId();
        Integer count =order.getCount();
        stockService.update(productId,count);
        log.info("==================>扣减完成end");
        log.info("=================>订单微服务开始调用支付服务，做扣减操作");
        Integer userId = order.getUserId();
        Integer money = order.getMoney();
        paymentService.update(userId,money);
        log.info("==================>扣减金额完成end");
        log.info("更新订单状态");
    }

    @Override
    public void update(Integer userId, Integer status) {
        //根据userId和status查询，set  status=1
        Order order = orderReposity.findByUserIdAndStatus(userId,status);
        order.setStatus(1);
        orderReposity.save(order);
    }
}
