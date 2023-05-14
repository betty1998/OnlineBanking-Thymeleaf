package com.example.OnlineBanking.bankService;

import com.example.OnlineBanking.model.BankService;
import com.example.OnlineBanking.model.BankServiceApplication;
import com.example.OnlineBanking.model.BankServiceApplicationStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BankServiceApplicationService {
    @Autowired
    private BankServiceApplicationRepository repository;

    public void applyForBankServices() {
        System.out.println("applyForBankServices in ApplicationService");
    }

    public BankServiceApplication addApplication(String id, String firstName, String lastName, String email, BankService bankService) {
        log.info("addApplication in ApplicationService");
        BankServiceApplication application = new BankServiceApplication();
        application.setId(id);
        application.setFirstName(firstName);
        application.setLastName(lastName);
        application.setEmail(email);
        application.setBankService(bankService);
        application.setStatus(BankServiceApplicationStatus.PENDING);

        return repository.save(application);
    }

    public BankServiceApplication getApplicationById(String applicationId) throws Exception {
        return repository.findById(applicationId)
                .orElseThrow(() -> new Exception("Application not found"));
    }

    public List<BankServiceApplication> getApplicationByName(String firstName, String lastName){
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }
}
