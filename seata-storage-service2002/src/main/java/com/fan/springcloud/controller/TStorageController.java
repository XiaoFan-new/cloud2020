package com.fan.springcloud.controller;

import com.fan.springcloud.entity.CommonResult;
import com.fan.springcloud.service.TStorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 库存(TStorage)表控制层
 *
 * @author makejava
 * @since 2020-05-20 15:54:40
 */
@RestController
public class TStorageController {
    /**
     * 服务对象
     */
    @Resource
    private TStorageService tStorageService;
    //减少库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,  Integer count){
        tStorageService.decrease(productId,count);
        return new CommonResult(200,"扣减成功！");
    }

}