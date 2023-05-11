package com.example.SpringSecurityDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(){
//        ModelAndView loginPage = new ModelAndView("login");
        System.out.println("login controller");
        return "login";
    }
}
