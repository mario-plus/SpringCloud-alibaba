package com.mario.nacos.sentinelHandle;

import org.springframework.web.bind.annotation.PathVariable;

/*
 * @author：ZXZ
 * @version 2020/3/13
 */
public class SentinelFallback {
    public static String fallbackHandle(@PathVariable String string, Throwable e){
        return "this is fallback deal with Exception"+e.getMessage();
    }
}
