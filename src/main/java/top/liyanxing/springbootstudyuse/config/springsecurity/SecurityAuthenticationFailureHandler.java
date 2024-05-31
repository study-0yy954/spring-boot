package top.liyanxing.springbootstudyuse.config.springsecurity;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudyuse.common.baseclass.ObjectMapperOpt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityAuthenticationFailureHandler implements AuthenticationFailureHandler
{
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
    {
        // 获取登录失败原因
        String localizedMessage = exception.getLocalizedMessage();

        // 生成json
        CommonResult<Object> result = CommonResult.errorMsg(localizedMessage);
        String jsonStr = SpringUtil.getBean(ObjectMapperOpt.class).getObjectMapper().writeValueAsString(result);

        // 返回给前端数据
        response.setContentType("application/json;charset=utf8");
        response.getWriter().println(jsonStr);
    }
}
