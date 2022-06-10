package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.AccountDetails;
import pl.coderslab.model.User;
import pl.coderslab.repository.AccountDetailsRepository;
import pl.coderslab.repository.UserRepository;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final AccountDetailsRepository accountDetailsRepository;

    public UserController(UserRepository userRepository, AccountDetailsRepository accountDetailsRepository) {
        this.userRepository = userRepository;
        this.accountDetailsRepository = accountDetailsRepository;
    }


    @GetMapping("/all")
    public String showPosts(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("user", users);
        return "/users/all";
    }

    @GetMapping("/save")
    public String save(Model model){
        model.addAttribute("user",new User());
        return "/users/save";
    }

    @PostMapping("/save")
    public String getForm(@Valid final User user, final BindingResult validationResult){
        if(validationResult.hasErrors()){
            return "/users/save";
        }
        userRepository.save(user);
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccountValue(0);
        accountDetailsRepository.save(accountDetails);
        user.setAccount(accountDetails);
        userRepository.save(user);
        return "redirect:all";
    }

    @GetMapping("/get/{id}")
    public String getOne(Model model, @PathVariable long id){
        model.addAttribute("user",userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
        return "/users/getone";
    }

    @GetMapping("delete/{id}")
    @Transactional
    public String delete(Model model, @PathVariable long id){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        User user = userRepository.getOne(id);
        accountDetailsRepository.deleteById(user.getAccount().getId());
        userRepository.deleteById(id);

        return "/users/all";
    }

    @GetMapping("/update/{id}")
    public String editById(@PathVariable long id, Model model){
        model.addAttribute("edit_url", "edit");
        model.addAttribute("user", userRepository.findById(id));
        return "users/update";
    }

    @PostMapping("/update")
    public String editUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/update";
        }
        userRepository.save(user);
        return "redirect:/user/all";
    }
}
