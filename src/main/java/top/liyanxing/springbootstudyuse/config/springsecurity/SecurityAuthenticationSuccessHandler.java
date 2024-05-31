package top.liyanxing.springbootstudyuse.config.springsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class SecurityAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    public static final ObjectMapper

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        Object principal = authentication.getPrincipal();


        response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
        response.getWriter().println("xxx");
    }
}
