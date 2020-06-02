package com.lhy.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/01 17:40
 */
public class CustomerBlockHandler {
    public static String handlerException1(BlockException exception) {
        return "按照客户自定义的Glogal 全局异常处理 ---- 1";
    }

    public static String handlerException2(BlockException exception) {
        return "按照客户自定义的Glogal 全局异常处理 ---- 2";
    }

}
