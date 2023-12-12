package com.common.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <b><code>SecurityConfig</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2023/12/12 22:09
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单提交
        http.formLogin()
                // 自定义登灵页面
                .loginPage("/login.html")
                // UsernamePasswordAuthenticationFilter
                // 自定义表单账号参数名
                // .usernameParameter("username")
                // 自定义表单密码参数名
                // .passwordParameter("password")
                // 必须和表单提交的接口一样，会去执行自定义登灵逻辑
                .loginProcessingUrl("/login")
                // 登录成功后跳转的页面，POST 请求
                .successForwardUrl("/login/success_forward")
                // 登录失败后跳转的页面，POST 请求
                .failureForwardUrl("/login/failure_forward");

        // 授权
        http.authorizeRequests()
                // 放行 /login.html，不需要认证
                .antMatchers("/login.html").permitAll()
                // 放行 /error.html，不需要认证
                .antMatchers("/error.html").permitAll()
                // 所有请求都必须认证才能访问，必须登录
                .anyRequest().authenticated();

        // 关闭 csrf 防护
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
