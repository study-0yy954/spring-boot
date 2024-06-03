package top.liyanxing.springbootstudyuse.config.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import top.liyanxing.springbootstudyuse.config.springsecurity.handler.SecurityAuthenticationFailureHandler;
import top.liyanxing.springbootstudyuse.config.springsecurity.handler.SecurityAuthenticationSuccessHandler;
import top.liyanxing.springbootstudyuse.config.springsecurity.handler.SecurityLogoutSuccessHandler;

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

        http.logout(logout -> logout.logoutSuccessHandler(new SecurityLogoutSuccessHandler()));

        http.httpBasic();
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
