package com.example.OnlineBanking.converter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConverterController {
    @GetMapping("converter")
    public String getConverterPage(){
        return "converter";
    }
}
