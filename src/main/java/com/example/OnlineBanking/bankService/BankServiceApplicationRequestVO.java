package com.example.OnlineBanking.bankService;

import com.example.OnlineBanking.bankService.BankService;
import lombok.Data;

@Data
public class BankServiceApplicationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private BankService bankService;

}
