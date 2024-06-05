package top.liyanxing.springbootstudyuse.config.springsecurity.handler;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudyuse.common.baseclass.ObjectMapperOpt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityAccessDeniedHandler implements AccessDeniedHandler
{
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException
    {
        // 生成json
        CommonResult<String> result = CommonResult.errorMsg("您没有权限访问此接口");
        String jsonStr = SpringUtil.getBean(ObjectMapperOpt.class).getObjectMapper().writeValueAsString(result);

        // 返回给前端数据
        response.setContentType("application/json;charset=utf8");
        response.getWriter().println(jsonStr);
        // response.setStatus(HttpStatus.HTTP_FORBIDDEN);
    }
}
