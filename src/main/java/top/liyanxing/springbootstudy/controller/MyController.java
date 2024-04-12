package top.liyanxing.springbootstudy.controller;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/foo")
    public ResponseEntity<String> foo()
    {
        Console.log("收到请求");
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("出错了");
    }

}