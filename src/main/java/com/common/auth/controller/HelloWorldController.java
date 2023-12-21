package com.common.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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
@Controller
@RequestMapping("/hello_world")
public class HelloWorldController {

    @GetMapping
    @ResponseBody
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/demo")
    public String demo(Map<String,Object> map){
        map.put("name", "Lily");
        return "demo";
    }

}
