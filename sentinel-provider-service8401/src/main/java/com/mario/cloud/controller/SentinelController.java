package com.mario.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mario.cloud.myhandle.SentinelHandle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author：ZXZ
 * @version 2020/3/13
 */
@RestController
public class SentinelController {
    @GetMapping("/getInfoA")
    public String getInfoA(){
        return "INFO:GOOD NIGHT! A";
    }
    @GetMapping("/getInfoB")
    public String getInfoB(){
        return "INFO:GOOD NIGHT! B ";
    }

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey",blockHandler = "deal_hotkey")
    public String hotKey(@RequestParam(value = "str1",required = false)String str1,
                         @RequestParam(value = "str2",required = false)String str2){
        return "......testHotKey";
    }
    public String deal_hotkey(String str1,String str2,BlockException e){
        return "自定义兜底方法";
    }

    //============>自定义处理规则
    @GetMapping("/myhandle")
    @SentinelResource(value = "myhandle",blockHandlerClass = SentinelHandle.class,blockHandler = "handle1")
    public String myHandle(){
        return "正常处理！";
    }

}
