package com.csu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    private Integer code;       //编码，类似404
    private String message;     //消息
    private T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}

