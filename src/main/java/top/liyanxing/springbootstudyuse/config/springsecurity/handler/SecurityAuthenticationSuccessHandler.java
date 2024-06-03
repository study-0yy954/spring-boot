package top.liyanxing.springbootstudyuse.config.springsecurity.handler;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudyuse.common.baseclass.ObjectMapperOpt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        // 获取用户数据
        Object principal = authentication.getPrincipal();

        // 生成json
        CommonResult<Object> result = CommonResult.successData(principal);
        String jsonStr = SpringUtil.getBean(ObjectMapperOpt.class).getObjectMapper().writeValueAsString(result);

        // 返回给前端数据
        response.setContentType("application/json;charset=utf8");
        response.getWriter().println(jsonStr);
    }
}
