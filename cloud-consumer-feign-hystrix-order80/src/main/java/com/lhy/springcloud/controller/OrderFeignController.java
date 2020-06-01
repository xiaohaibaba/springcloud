package com.lhy.springcloud.controller;

import com.lhy.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value="/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_OK(id);
    }

    @GetMapping(value="/payment/hystrix/timeout/{id}")
    String paymentInfo_timeout(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_Timeout(id);
    }

    @GetMapping(value="/payment/hystrix/globaltimeout/{id}")
    @HystrixCommand
    String paymentInfo_globaltimeout(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_Timeout(id);
    }

    @GetMapping(value="/payment/hystrix/diytimeout/{id}")
    @HystrixCommand(fallbackMethod = "diyFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")
    })
    String paymentInfo_diytimeout(@PathVariable("id") Integer id) throws InterruptedException {
        return paymentFeignService.paymentInfo_Timeout(id);
    }

    /**
     * 自定义的需要参数和原接口一致
     * @param id
     * @return
     */
    public String diyFallbackMethod(Integer id){
        return "我是消费者80自定义异常，系统繁忙 请重试";
    }

    public String globalFallbackMethod(){
        return "我是消费者80全局异常，系统繁忙 请重试";
    }

}
