package com.example.OnlineBanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/","/home"})
    public String welcome(){
        return "home";
    }
    @GetMapping("/aboutus")
    public String aboutUs(){
        return "aboutus";
    }


}
