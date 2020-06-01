package com.lhy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/29 15:36
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderOpenFeignMian80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMian80.class, args);
    }
}
