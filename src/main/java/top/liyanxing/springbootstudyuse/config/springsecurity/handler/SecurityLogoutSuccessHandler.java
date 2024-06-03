package top.liyanxing.springbootstudyuse.config.springsecurity.handler;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudyuse.common.baseclass.ObjectMapperOpt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityLogoutSuccessHandler implements LogoutSuccessHandler
{
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        // 生成json
        CommonResult<String> result = CommonResult.successData("注销成功");
        String jsonStr = SpringUtil.getBean(ObjectMapperOpt.class).getObjectMapper().writeValueAsString(result);

        // 返回给前端数据
        response.setContentType("application/json;charset=utf8");
        response.getWriter().println(jsonStr);
    }
}