package com.example.OnlineBanking.bankService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank-services")
public class bankServiceController {
    @GetMapping()
    public String getBankServices(){
        return "bankService";
    }
}
