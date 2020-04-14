package com.mario.seata.service;

import com.mario.seata.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */

public interface PaymentService {
    void update(Integer userId,Integer money);
}
