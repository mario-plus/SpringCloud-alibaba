package com.mario.cloud2020.rest;

import com.mario.cloud2020.entity.Payment;

/*
 * @author：ZXZ
 * @version 2020/3/7
 */
public interface PaymentService {
    public Payment save(Payment payment);
    public Payment getById(Integer id);
}
