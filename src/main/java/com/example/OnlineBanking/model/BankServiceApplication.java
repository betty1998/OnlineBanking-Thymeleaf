package com.example.OnlineBanking.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankServiceApplication {
    // The user can apply for bank services such as accounts, credit cards, loans. To apply the bank services, the user is required to fill out the form on the website.
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private BankService bankService;

    @Enumerated(EnumType.STRING)
    private BankServiceApplicationStatus status;

}