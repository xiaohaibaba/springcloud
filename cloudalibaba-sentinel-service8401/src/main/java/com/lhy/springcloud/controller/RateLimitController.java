package com.lhy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lhy.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/01 17:27
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public String byResource(){
        return "按照资源名称限流测试成功";
    }

    public String handleException(BlockException e){
        return "按照资源名称限流测试异常" + getClass().getCanonicalName();
    }

    @GetMapping("/rateLimit/customerBlockHandler2")
    @SentinelResource(value = "customerBlockHandler2",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public String customerBlockHandler2(){
        return "handlerException2";
    }

    @GetMapping("/rateLimit/customerBlockHandler1")
    @SentinelResource(value = "customerBlockHandler1",blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public String customerBlockHandler1(){
        return "handlerException1";
    }
}
