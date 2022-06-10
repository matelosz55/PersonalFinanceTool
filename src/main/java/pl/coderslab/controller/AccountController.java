package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.AccountDetails;
import pl.coderslab.repository.AccountDetailsRepository;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final AccountDetailsRepository accountDetailsRepository;

    public AccountController(AccountDetailsRepository accountDetailsRepository) {
        this.accountDetailsRepository = accountDetailsRepository;
    }


    @GetMapping("/all")
    public String showExpenses(Model model){
        List<AccountDetails> accountDetails = accountDetailsRepository.findAll();
        model.addAttribute("accounts", accountDetails);
        return "/accounts/all";
    }
}
