package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    /**
     * 自定义登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
