package com.mario.nacos.sentinelHandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * @author：ZXZ
 * @version 2020/3/13
 */
public class Sentinelblockhandle {
    public static String sentinelblockhandle(@PathVariable String string, BlockException e){
        return "BlockException!"+e.getMessage();
    }
}
