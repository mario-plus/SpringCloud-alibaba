package com.mario.cloud.service.fallbackImpl;

import com.mario.cloud.service.HystrixFeignPaymentService;
import org.springframework.stereotype.Service;

import java.util.Date;

/*
 * @author：ZXZ
 * @version 2020/3/10
 */
@Service
public class HystrixFeignPaymentServiceImpl implements HystrixFeignPaymentService {
    @Override
    public String paymentInfo_Ok() {
        return "方法类实现服务降级....ok"+new Date();
    }
    @Override
    public String paymentInfo_timeOut() {
        return "方法类实现服务降级....timeout"+new Date();
    }
}
