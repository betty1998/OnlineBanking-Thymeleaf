package com.example.OnlineBanking.contactUs;

import com.example.OnlineBanking.model.ContactUsForm;
import com.example.OnlineBanking.contactUs.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsService {
    @Autowired
    ContactUsRepository contactUsRepository;

    public ContactUsForm saveForm(ContactUsForm form) {
        return contactUsRepository.save(form);
    }
}
