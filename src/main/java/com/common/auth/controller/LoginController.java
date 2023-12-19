package com.common.auth.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <b><code>LoginController</code></b>
 * <p/>
 * 登录
 * <p/>
 * <b>Creation Time:</b> 2023/12/11 22:49
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    // @Secured("ROLE_abc")
    // PreAuthorize 允许角色以 ROLE_ 开头，也可以不以 ROLE_ 开头，但是配置类不允许以 ROLE_ 开头
    // @PreAuthorize("ROLE_abc")
    @PostMapping("/success_forward")
    // @ResponseBody
    public String successForward(){
        return "redirect:/main.html";
    }

    @PostMapping("/failure_forward")
    // @ResponseBody
    public String failureForward(){
        return "redirect:/error.html";
    }
}
