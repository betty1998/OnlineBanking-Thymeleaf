package com.example.OnlineBanking.bankService;

import com.example.OnlineBanking.model.BankServiceApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankServiceApplicationRepository extends JpaRepository<BankServiceApplication, String> {
    List<BankServiceApplication> findByFirstNameAndLastName(String firstName, String lastName);

}
