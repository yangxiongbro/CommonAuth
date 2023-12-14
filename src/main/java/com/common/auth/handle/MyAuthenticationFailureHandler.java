package com.common.auth.handle;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <b><code>MyAuthenticationFailureHandler</code></b>
 * <p/>
 * 自定义登录失败处理器
 * <p/>
 * <b>Creation Time:</b> 2023/12/14 21:52
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private String url;

    public MyAuthenticationFailureHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest reguest, HttpServletResponse response, AuthenticationException exception) throws IOException {
        System.out.println("自定义登录失败处理器");
        response.sendRedirect(url);
    }
}