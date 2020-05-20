package com.fan.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Create by fan
 * on 2020/5/13 20:49
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
