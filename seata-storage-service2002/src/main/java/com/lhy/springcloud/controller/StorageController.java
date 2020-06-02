package com.lhy.springcloud.controller;

import com.lhy.springcloud.domain.CommonResult;
import com.lhy.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/02 0:35
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功!");
    }
}
