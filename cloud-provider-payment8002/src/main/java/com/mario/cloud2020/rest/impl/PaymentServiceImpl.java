package com.mario.cloud2020.rest.impl;

import com.mario.cloud2020.dao.PaymentRopository;
import com.mario.cloud2020.entity.Payment;
import com.mario.cloud2020.rest.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
 * @author：ZXZ
 * @version 2020/3/7
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRopository paymentRopository;
    @Override
    public Payment save(Payment payment) {
        return paymentRopository.save(payment);
    }

    @Override
    public Payment getById(Integer id) {
        Payment payment = paymentRopository.findById(id).get();
        return payment;
    }
}
