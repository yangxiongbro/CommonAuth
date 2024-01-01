package com.common.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b><code>UserController</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2024/1/1 23:08
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public Object userInfo(Authentication authentication){
        return authentication.getPrincipal();
    }
}
