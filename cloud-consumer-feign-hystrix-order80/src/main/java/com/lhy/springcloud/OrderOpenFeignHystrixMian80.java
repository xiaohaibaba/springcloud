package com.lhy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/29 15:36
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderOpenFeignHystrixMian80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignHystrixMian80.class, args);
    }
}
