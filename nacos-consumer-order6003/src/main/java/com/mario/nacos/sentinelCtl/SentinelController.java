package com.mario.nacos.sentinelCtl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mario.nacos.sentinelHandle.SentinelFallback;
import com.mario.nacos.sentinelHandle.Sentinelblockhandle;
import com.mario.nacos.service.OpenfeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
 * @author：ZXZ
 * @version 2020/3/13
 * 用于sentinel测试
 */
@RestController
public class SentinelController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OpenfeignService openfeignService;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;


    @GetMapping(value = "/sentinel/{string}")
    //@SentinelResource(value="hello",fallbackClass = {SentinelFallback.class},fallback = "fallbackHandle")
    @SentinelResource(value="hello",
            fallbackClass = {SentinelFallback.class},
            fallback = "fallbackHandle",
            blockHandlerClass ={Sentinelblockhandle.class},
            blockHandler = "sentinelblockhandle")
    public String echo(@PathVariable String string){
        int i = 10/0;       //java异常
        return restTemplate.getForObject(serverURL+"/echo/"+string,String.class);
    }

    //使用OpenFeign调用接口
    @GetMapping(value = "/sentinelAndOpenFeign/{string}")
    @SentinelResource(value="hello",
            fallbackClass = {SentinelFallback.class},
            fallback = "fallbackHandle",
            blockHandlerClass ={Sentinelblockhandle.class},
            blockHandler = "sentinelblockhandle")
    public String echo2(@PathVariable String string){
        int i = 10/0;       //java异常
        return openfeignService.echo(string);
    }
}
