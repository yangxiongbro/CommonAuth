package com.common.auth.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <b><code>MyAuthenticationSuccessHandler</code></b>
 * <p/>
 * 自定义登陆成功处理器
 * <p/>
 * <b>Creation Time:</b> 2023/12/14 21:47
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public MyAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess (HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        System.out.println("自定义登陆成功处理器");
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername());
        // 输出nul1
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        response.sendRedirect(url);
    }
}