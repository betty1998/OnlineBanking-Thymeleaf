package com.example.OnlineBanking.bankService;

import com.example.OnlineBanking.model.BankServiceApplication;
import com.example.OnlineBanking.model.BankServiceApplicationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/bank-services")
@Slf4j
public class BankServiceApplicationController {
    @Autowired
    private BankServiceApplicationService service;

    @GetMapping("/apply")
    public String showApplyForBankServiceForm(Model model) {
        log.info("showApplyForBankServiceForm in BankServiceApplicationController");
        model.addAttribute("applicationRequest", new BankServiceApplicationRequest());
        model.addAttribute("title","Apply");
        return "applyForServiceApplication";
    }

    @PostMapping("/submit")
    public String applyForBankService(@ModelAttribute("applicationRequest") BankServiceApplicationRequest request,
                                      RedirectAttributes redirectAttributes, Model model) {
        log.info("applyForBankService in BankServiceApplicationController");
        String id = UUID.randomUUID().toString();
        BankServiceApplication application = service.addApplication(
                id,
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getBankService()
        );
        redirectAttributes.addFlashAttribute("message", "Bank service application submitted successfully!  You can check all applications status here.");
        redirectAttributes.addAttribute("application", application);
        redirectAttributes.addAttribute("firstName",request.getFirstName());
        redirectAttributes.addAttribute("lastName",request.getLastName());
        return "redirect:/bank-services/application-status";
    }

//    @GetMapping("/application-status/{id}")
//    public String getApplicationStatus(@PathVariable("id") String applicationId, Model model) throws Exception {
//        log.info("getApplicationStatus in BankServiceApplicationController");
//        BankServiceApplication application = service.getApplicationById(applicationId);
//        model.addAttribute("application", Arrays.asList(application));
//        return "applicationStatus";
//    }
    @GetMapping("/application-status")
    public String getApplicationStatus(@RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName, Model model) throws Exception {
        log.info("getApplicationStatus in BankServiceApplicationController");
        List<BankServiceApplication> applications = service.getApplicationByName(firstName, lastName);
        model.addAttribute("applications", applications);
        return "applicationStatus";
    }

    @GetMapping("/track")
    public String trackApplication(){
        return "trackApplication";
    }

    @PostMapping("/track")
    public String trackApplication(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   RedirectAttributes redirectAttributes){
        log.info("trackApplication in BankServiceApplicationController");
        redirectAttributes.addAttribute("firstName",firstName);
        redirectAttributes.addAttribute("lastName",lastName);
        return "redirect:/bank-services/application-status";
    }
}
