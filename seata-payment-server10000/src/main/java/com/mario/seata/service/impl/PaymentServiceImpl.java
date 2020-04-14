package com.mario.seata.service.impl;

import com.mario.seata.domain.Payment;
import com.mario.seata.repository.PaymentRepository;
import com.mario.seata.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void update(Integer userId, Integer money) {
        Payment payment=  paymentRepository.findByUserId(userId);
        payment.setTotal(payment.getTotal()-money);//金额减少money
        payment.setUsed(payment.getUsed()+money);   //已用增加money
        payment.setResidue(payment.getResidue()-money); //剩余减少money
        paymentRepository.save(payment);
    }
}
