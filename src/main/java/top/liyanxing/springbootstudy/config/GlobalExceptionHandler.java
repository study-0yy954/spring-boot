package top.liyanxing.springbootstudy.config;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.liyanxing.common.CommonResult;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ResponseBody
    @ExceptionHandler({Exception.class})
    public CommonResult<String> handException(Exception e)
    {
        return CommonResult.successMsgData(StrUtil.format("全局捕获异常 {}", DateUtil.now()), e.getMessage());
    }
}
