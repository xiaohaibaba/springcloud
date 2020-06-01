package com.lhy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/28 23:43
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/consul")
    public String paymentconsul() {
        return "springcloud with consul:" + port + "\t"
                + UUID.randomUUID().toString();
    }


}
