package com.lhy.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/29 15:41
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
//@FeignClient(value = "CLOUD-PAYMENT-SERVICE", fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/payment/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
