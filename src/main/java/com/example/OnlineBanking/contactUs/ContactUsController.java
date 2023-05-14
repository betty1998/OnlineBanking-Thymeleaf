package com.example.OnlineBanking.contactUs;

import com.example.OnlineBanking.model.ContactUsForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/contactus")
public class ContactUsController {
    @Autowired
    private ContactUsService contactUsService;

    @GetMapping()
    public String showContactUsForm(Model model) {
        return "contactus";
    }

    @PostMapping("/submit")
    public String submitContactForm(@ModelAttribute("contactUsForm") ContactUsForm form) {
        log.info("submitContactForm in ContactUsController");
        contactUsService.saveForm(form);
        return "redirect:/contactus/success";
    }

    @GetMapping("/success")
    public String showSuccessPage(Model model) {
        model.addAttribute("PageTitle", "Contact Us - Success");
        return "contactUsSuccess";
    }

}
