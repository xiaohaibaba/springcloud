package com.lhy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/28 22:51
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/zk")
    public String paymentzk() {
        return "springcloud with zookeeper:" + port + "\t"
                + UUID.randomUUID().toString();
    }


}
