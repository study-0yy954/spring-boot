package com.lyx.controller;

import com.lyx.common.CommonResult;
import com.lyx.thrid.hutool.core.util.IdUtil;
import com.lyx.thrid.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController
{
    @GetMapping("/zTest")
    public CommonResult<String> zTest()
    {
        return CommonResult.successData(StrUtil.format("成功调用了：{}", IdUtil.fastSimpleUUID()));
    }
}