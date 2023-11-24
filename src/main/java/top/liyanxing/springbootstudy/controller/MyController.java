package top.liyanxing.springbootstudy.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudy.service.MyService;

@RestController
public class MyController
{
    @Autowired
    private MyService myService;

    @GetMapping("/test1")
    public CommonResult<String> test1()
    {
        return myService.test1();
    }
}