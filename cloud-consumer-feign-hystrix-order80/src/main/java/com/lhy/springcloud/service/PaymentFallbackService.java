package com.lhy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/29 22:19
 */
@Component
public class PaymentFallbackService implements PaymentFeignService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_Timeout,o(╥﹏╥)o";
    }

}
