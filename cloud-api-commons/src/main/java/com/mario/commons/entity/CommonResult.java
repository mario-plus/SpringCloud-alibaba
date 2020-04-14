package com.mario.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author：ZXZ
 * @version 2020/3/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //返回给前端的格式
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
