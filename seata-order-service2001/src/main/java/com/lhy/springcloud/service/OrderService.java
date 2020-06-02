package com.lhy.springcloud.service;

import com.lhy.springcloud.domain.Order;

public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

}
