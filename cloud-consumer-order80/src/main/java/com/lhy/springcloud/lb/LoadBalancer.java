package com.lhy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/29 11:34
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
