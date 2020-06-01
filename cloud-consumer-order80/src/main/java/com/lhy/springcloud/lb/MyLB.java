package com.lhy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/29 11:35
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current, next;
        do {
            //获取当前的当前的访问次数
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("****第几次访问，次数next: " + next);
        return next;
    }

    // 负载均衡轮询算法，rest接口第几次请求数 % 服务器集群总数 = 实际调用服务器位置下标
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //使用与运算代替模运算
        int index = getAndIncrement() & (serviceInstances.size() - 1);
        System.out.println("分配服务器下标："+index);
        return serviceInstances.get(index);
    }


}
