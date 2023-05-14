package com.example.OnlineBanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(){
        System.out.println("login controller");
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        System.out.println("register controller");
        return "register";
    }
}
