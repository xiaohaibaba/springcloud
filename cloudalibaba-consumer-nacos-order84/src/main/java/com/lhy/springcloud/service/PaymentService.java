package com.lhy.springcloud.service;

import com.lhy.springcloud.entities.CommonResult;
import com.lhy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping("/paymentSQL/{id}")
    CommonResult<Payment> paymenSQL(@PathVariable(value = "id") Long id);
}
