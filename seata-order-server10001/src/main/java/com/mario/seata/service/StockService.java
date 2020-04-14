package com.mario.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@Component
@FeignClient(value = "seata-stock-server10003")
public interface StockService {
    @GetMapping("/updateStock")
    public void update(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count);
}
