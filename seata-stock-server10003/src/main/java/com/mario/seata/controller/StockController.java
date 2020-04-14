package com.mario.seata.controller;

import com.mario.seata.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@RestController
public class StockController {
    @Autowired
    StockService stockService;
    @GetMapping("/updateStock")
    public void update(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count){
        stockService.update( productId, count);
    }
}
