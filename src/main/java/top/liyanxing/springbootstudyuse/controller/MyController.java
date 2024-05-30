package top.liyanxing.springbootstudyuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.liyanxing.common.CommonResult;

@RestController
public class MyController
{
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/beans")
    public CommonResult<String[]> beans()
    {
        return CommonResult.successData(applicationContext.getBeanDefinitionNames());
    }
}