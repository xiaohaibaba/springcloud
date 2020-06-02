package com.lhy.springcloud.controller;

import com.lhy.springcloud.domain.CommonResult;
import com.lhy.springcloud.domain.Order;
import com.lhy.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/02 0:08
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

}
