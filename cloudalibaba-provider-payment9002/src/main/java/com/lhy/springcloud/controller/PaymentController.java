package com.lhy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/31 20:25
 */
@RestController
@RequestMapping("/payment")
@RefreshScope // 支持Nacos的动态刷新功能
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/get/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "Hello Nacos Discovery: " + serverPort + "\t id: " + id;
    }

    @GetMapping(value = "/configInfo")
    public String configInfo() {
        return "Hello Nacos Discovery: " + configInfo;
    }
}