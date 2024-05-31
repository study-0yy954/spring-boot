package top.liyanxing.springbootstudyuse.config.springmvc;

import cn.hutool.core.exceptions.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.liyanxing.common.CommonResult;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public CommonResult<String> handException(Exception e)
    {
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            List<ObjectError> allErrors = bindException.getBindingResult().getAllErrors();
            String errorMsg = allErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining("、"));
            return CommonResult.errorMsg("全局捕获异常【{}】", errorMsg);
        }
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
            List<ObjectError> allErrors = validException.getBindingResult().getAllErrors();
            String errorMsg = allErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining("、"));
            return CommonResult.errorMsg("全局捕获异常【{}】", errorMsg);
        }
        return CommonResult.errorMsg("全局捕获异常【{}】", ExceptionUtil.stacktraceToOneLineString(e));
    }
}
