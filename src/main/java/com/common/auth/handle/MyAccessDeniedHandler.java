package com.common.auth.handle;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <b><code>MyAccessDeniedHandler</code></b>
 * <p/>
 * 403处理
 * <p/>
 * <b>Creation Time:</b> 2023/12/19 22:44
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 响应状态
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        // 返回 json 格式
        response.setHeader("Content-Type","application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("{\"status\":\"error\",\"msg\":\"没有权限\"}");
        writer.flush();
        writer.close();
    }
}
