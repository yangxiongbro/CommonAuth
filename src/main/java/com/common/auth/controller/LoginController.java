package com.common.auth.controller;

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

    @PostMapping("/success_forward")
//    @ResponseBody
    public String successForward(){
        return "redirect:/main.html";
    }

    @PostMapping("/failure_forward")
//    @ResponseBody
    public String failureForward(){
        return "redirect:/error.html";
    }
}
