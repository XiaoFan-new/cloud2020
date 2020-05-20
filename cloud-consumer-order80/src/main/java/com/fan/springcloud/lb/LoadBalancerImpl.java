package com.fan.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by fan
 * on 2020/5/13 20:47
 */
@Component
public class LoadBalancerImpl implements LoadBalancer{
    //java并发原子类AtomicInteger
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    public final int getAndIncrement(){
        int current;//当前值
        int next;//下一个值
        //自旋锁
        do {
            current=this.atomicInteger.get();
            next=current >= 2147483647 ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第几次访问,次数next："+next);
        return next;
    }
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index= getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
