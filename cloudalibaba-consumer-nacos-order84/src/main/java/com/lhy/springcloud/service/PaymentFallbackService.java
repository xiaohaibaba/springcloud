package com.lhy.springcloud.service;

import com.lhy.springcloud.entities.CommonResult;
import com.lhy.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/01 22:18
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymenSQL(Long id) {
        return new CommonResult<>(444, "兜底方法 服务降级返回", null);
    }
}
