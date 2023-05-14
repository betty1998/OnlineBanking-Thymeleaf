package com.example.OnlineBanking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class ContactUsForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String message;

    public ContactUsForm(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

}
