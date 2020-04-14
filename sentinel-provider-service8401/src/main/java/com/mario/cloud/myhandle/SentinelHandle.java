package com.mario.cloud.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/*
 * @author：ZXZ
 * @version 2020/3/13
 */
public class SentinelHandle {
    public static String handle1(BlockException e){
        return "this is handle1 deal with the Exception";
    }
    public static String handle2(BlockException e){
        return "this is handle2 deal with the Exception";
    }
}
