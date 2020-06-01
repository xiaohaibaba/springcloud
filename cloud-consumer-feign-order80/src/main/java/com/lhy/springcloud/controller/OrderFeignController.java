package com.lhy.springcloud.controller;

import com.lhy.springcloud.entities.CommonResult;
import com.lhy.springcloud.entities.Payment;
import com.lhy.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/29 15:38
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/lb")
    public String lb(){
        return paymentFeignService.lb();
    }

    @GetMapping(value="/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @RequestMapping("/timeout")
    public String timeout(){
        return paymentFeignService.timeout();
    }
}
