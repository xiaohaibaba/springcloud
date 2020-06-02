package com.lhy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lhy.springcloud.entities.CommonResult;
import com.lhy.springcloud.entities.Payment;
import com.lhy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/01 21:16
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {
    @Value("${server-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/fallback/{id}")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback",
    exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable(value = "id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        }
        if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }

    public CommonResult handlerFallback(Long id,Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"异常handlerFallback，exception内容： " + e.getMessage(), payment);

    }

    public CommonResult blockHandler(Long id, BlockException exception){
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"异常blockHandler，exception内容： " + exception.getMessage(), payment);

    }

    @RequestMapping("/paymentSQL/{id}")
    @SentinelResource(value = "paymentSQL",exceptionsToIgnore = {IllegalArgumentException.class},
    fallback = "handlerFallback",blockHandler = "blockHandler")
    public CommonResult<Payment> paymentSQL(@PathVariable(value = "id") Long id) {
        CommonResult<Payment> result = paymentService.paymenSQL(id);
//        if (id == 4) {
//            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
//        }
//        if (result.getData() == null) {
//            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
//        }
        return result;
    }
}
