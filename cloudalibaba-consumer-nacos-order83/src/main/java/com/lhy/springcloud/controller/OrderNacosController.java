package com.lhy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/31 20:39
 */
@RestController
@RequestMapping("/consumer")
@RefreshScope // 支持Nacos的动态刷新功能
@Slf4j
public class OrderNacosController {

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverURL + "/payment/nacos/" + id,String.class);
    }

    @GetMapping(value = "/payment/nacos")
    public String nacos() {
        return restTemplate.getForObject(serverURL + "/payment/configInfo/",String.class);
    }

    @GetMapping(value = "/configInfo")
    public String configInfo() {
        return "Hello Nacos Discovery: " + configInfo;
    }


}
