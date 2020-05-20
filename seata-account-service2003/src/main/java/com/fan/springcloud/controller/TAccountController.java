package com.fan.springcloud.controller;

import com.fan.springcloud.entity.CommonResult;
import com.fan.springcloud.entity.TAccount;
import com.fan.springcloud.service.TAccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 账户表(TAccount)表控制层
 *
 * @author makejava
 * @since 2020-05-20 16:38:57
 */
@RestController
public class TAccountController {
    /**
     * 服务对象
     */
    @Resource
    private TAccountService tAccountService;

    //减少余额
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        tAccountService.decrease(userId,money);
        return new CommonResult(200,"余额扣减成功！");
    }

}