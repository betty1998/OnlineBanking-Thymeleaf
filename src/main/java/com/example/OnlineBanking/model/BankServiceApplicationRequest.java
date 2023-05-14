package com.example.OnlineBanking.model;

import lombok.Data;

@Data
public class BankServiceApplicationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private BankService bankService;

}
