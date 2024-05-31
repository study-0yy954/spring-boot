package top.liyanxing.springbootstudyuse.config.springsecurity;

import cn.hutool.extra.spring.SpringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
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
        CommonResult<Object> resut = CommonResult.successData(principal);
        String jsonStr = SpringUtil.getBean(ObjectMapperOpt.class).getObjectMapper().writeValueAsString(request);

        // 返回给前端数据
        response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
        response.getWriter().println(jsonStr);
    }
}
