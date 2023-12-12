package com.common.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b><code>HelloworldController</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2023/12/12 22:34
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
@RestController
@RequestMapping("/hello_world")
public class HelloWorldController {

    @GetMapping
    public String helloWorld(){
        return "Hello World!";
    }

}
