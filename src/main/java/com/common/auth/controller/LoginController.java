package com.common.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/success_forward")
    public String successForward(){
        return "successForward!";
    }

    @PostMapping("/failure_forward")
    public String failureForward(){
        return "failureForward!";
    }
}
