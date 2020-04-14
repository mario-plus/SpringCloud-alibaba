package com.mario.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@Component
@FeignClient(value = "nacos-provider-paymnet")
public interface OpenfeignService {
    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable(value = "string") String string);
}
