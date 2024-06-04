package top.liyanxing.springbootstudyuse.config.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import top.liyanxing.springbootstudyuse.config.springsecurity.handler.*;

@Configuration
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated();

        http.formLogin()
            .successHandler(new SecurityAuthenticationSuccessHandler())
            .failureHandler(new SecurityAuthenticationFailureHandler());

        // session.maximumSessions(1) 代表一个账号只能同时存在1个会话，也就是说一个账号只能在一个客户端上登录.
        http.sessionManagement(session -> session.maximumSessions(1).expiredSessionStrategy(new SecuritySessionInformationExpiredStrategy()));

        http.logout(logout -> logout.logoutSuccessHandler(new SecurityLogoutSuccessHandler()));
        http.exceptionHandling(cus -> cus.authenticationEntryPoint(new SecurityAuthenticationEntryPoint()));
        http.httpBasic();
        http.cors();
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
