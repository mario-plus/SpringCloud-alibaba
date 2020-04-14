package com.mario.cloud.service;

/*
 * @author：ZXZ
 * @version 2020/3/10
 */
public interface PaymentService {
    public String paymentInfo_Ok();
    public String paymentInfo_timeOut();
    public String paymentCircuitBreaker(Integer id);
}
