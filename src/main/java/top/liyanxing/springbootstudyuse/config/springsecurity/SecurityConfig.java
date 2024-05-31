package top.liyanxing.springbootstudyuse.config.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
            .antMatchers("/public/**").permitAll() // 不拦截public开头的路径
            .anyRequest().authenticated(); // 其他的路径全拦截
        http.formLogin(); // 添加登录表单
        http.httpBasic(); // 使用基本授权方式
        http.csrf(csrf -> csrf.disable()); // 关闭csrf防护
        return http.build();
    }
}
