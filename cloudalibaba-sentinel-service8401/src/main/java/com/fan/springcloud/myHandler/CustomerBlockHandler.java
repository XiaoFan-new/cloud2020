package com.fan.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fan.springcloud.entities.CommonResult;

/**
 * Create by fan
 * on 2020/5/18 21:15
 */

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException e){
        return new CommonResult(4444,"按照客户自定义，handlerException*********1");
    }
    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(4444,"按照客户自定义，handlerException*********2");
    }
}
