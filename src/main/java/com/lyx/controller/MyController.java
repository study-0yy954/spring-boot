package com.lyx.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.liyanxing.common.CommonResult;

@RestController
public class MyController
{
    @GetMapping("/zTest")
    public CommonResult<String> zTest()
    {
        return CommonResult.successData(StrUtil.format("成功调用了：{}", IdUtil.fastSimpleUUID()));
    }
}