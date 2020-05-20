package com.fan.springcloud.controller;

import com.fan.springcloud.entities.CommonResult;
import com.fan.springcloud.entities.Payment;
import com.fan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    /**
     *  端口号
     *  查看负载均衡
     */
    @Value("${server.port}")
    private String serverPort; //端口号
    /**
     *  服务发现 获取服务信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result>0){
            return new CommonResult(200,"插入数据库成功，serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败，serverPort:"+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询成功，serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id+"serverPort:"+serverPort,null);
        }
    }

    /**
     *  服务发现
     * @return
     */
    @GetMapping("payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**********element:"+service);
        }
        //一个微服务下的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "测试********************************";
    }

}
