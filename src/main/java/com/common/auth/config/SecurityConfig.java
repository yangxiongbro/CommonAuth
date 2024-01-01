package com.common.auth.config;

import com.common.auth.handle.MyAuthenticationFailureHandler;
import com.common.auth.handle.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

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
//@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单提交
        http.formLogin()
                // 自定义登灵页面
                // .loginPage("/login.html")
                 .loginPage("/login/loginWithCsrf")
                // UsernamePasswordAuthenticationFilter
                // 自定义表单账号参数名
                // .usernameParameter("username")
                // 自定义表单密码参数名
                // .passwordParameter("password")
                // 必须和表单提交的接口一样，会去执行自定义登灵逻辑
                .loginProcessingUrl("/login")
                // 登录成功后跳转的页面，POST 请求
                .successForwardUrl("/login/success_forward")
                // 自定义登陆成功处理器
                // .successHandler(new MyAuthenticationSuccessHandler("/common/auth/main.html"))
                // 登录失败后跳转的页面，POST 请求
                .failureForwardUrl("/login/failure_forward");
                // 自定义登录失败处理器
        // .failureHandler(new MyAuthenticationFailureHandler("/common/auth/error.html"))
        ;

        // 授权
        http.authorizeRequests()
                // 放行 /login.html，不需要认证
                // .antMatchers("/login.html").permitAll()
                .antMatchers("/login/loginWithCsrf").permitAll()
                // 放行 /error.html，不需要认证
                .antMatchers("/error.html").permitAll()
                // oauth 端点
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/main.html").hasIpAddress("127.0.0.1")
                // 所有请求都必须认证才能访问，必须登录，anyRequest 要放在最后
                .anyRequest().authenticated()
        ;

        // 异常处理
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
        ;

        // 记住我
        http.rememberMe()
                // 数据源
                .tokenRepository(persistentTokenRepository)
                // 参数
                // .rememberMeParameter()
                // 过期时间 60s(默认两周)
                 .tokenValiditySeconds(60)
                // 自定义登录逻辑
                 .userDetailsService(userDetailsService)
        ;

        // 退出登录
        http.logout()
                // 修改退出登录 url
                // .logoutUrl("/user/logout")
                // 退出成功后转跳的页面
                .logoutSuccessUrl("/login")
        ;

        // 关闭 csrf 防护
        // http.csrf().disable();
    }
}
