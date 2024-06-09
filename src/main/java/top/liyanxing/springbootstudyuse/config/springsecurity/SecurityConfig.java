package top.liyanxing.springbootstudyuse.config.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import top.liyanxing.springbootstudyuse.config.springsecurity.handler.*;

@Configuration
@EnableMethodSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
            .antMatchers("/user/list").hasRole("MANAGER")
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated();

        http.formLogin()
            .successHandler(new SecurityAuthenticationSuccessHandler())
            .failureHandler(new SecurityAuthenticationFailureHandler());

        http.exceptionHandling
        (
            cus ->
            {
                cus.authenticationEntryPoint(new SecurityAuthenticationEntryPoint());
                cus.accessDeniedHandler(new SecurityAccessDeniedHandler());
            }
        );

        http.sessionManagement(session -> session.maximumSessions(1).expiredSessionStrategy(new SecuritySessionInformationExpiredStrategy()));
        http.logout(logout -> logout.logoutSuccessHandler(new SecurityLogoutSuccessHandler()));
        http.httpBasic();
        http.cors();
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
