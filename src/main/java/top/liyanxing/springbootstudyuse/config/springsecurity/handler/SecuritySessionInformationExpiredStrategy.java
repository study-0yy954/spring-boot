package top.liyanxing.springbootstudyuse.config.springsecurity.handler;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudyuse.common.baseclass.ObjectMapperOpt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 会话过期策略，session过期是会执行这里的代码.
 */
public class SecuritySessionInformationExpiredStrategy implements SessionInformationExpiredStrategy
{
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException
    {
        // 生成json
        CommonResult<String> result = CommonResult.successData("该账号已从其他设备登录");
        String jsonStr = SpringUtil.getBean(ObjectMapperOpt.class).getObjectMapper().writeValueAsString(result);

        // 返回给前端数据
        HttpServletResponse response = event.getResponse(); // 从 event 参数中获取响应报文
        response.setContentType("application/json;charset=utf8");
        response.getWriter().println(jsonStr);
    }
}
