package com.example.OnlineBanking.contactUs;

import com.example.OnlineBanking.model.ContactUsForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<ContactUsForm, Long> {
}
