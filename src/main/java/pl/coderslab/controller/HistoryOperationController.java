package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.HistoryOperation;
import pl.coderslab.model.User;
import pl.coderslab.repository.HistoryOperationsRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryOperationController {
    private final HistoryOperationsRepository historyOperationsRepository;
    private final UserRepository userRepository;

    public HistoryOperationController(HistoryOperationsRepository historyOperationsRepository, UserRepository userRepository) {
        this.historyOperationsRepository = historyOperationsRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public String showExpenses(Model model){
        List<HistoryOperation> historyOperations = historyOperationsRepository.findAll();
        model.addAttribute("historyOperation", historyOperations);
        return "/historyOperations/all";
    }

    @GetMapping("/save")
    public String save(Model model){
        model.addAttribute("historyOperation",new HistoryOperation());
        List<User> users = userRepository.findAll();
        model.addAttribute("user",users);
        return "/historyOperations/save";
    }

    @PostMapping("/save")
    public String getForm(@Valid final HistoryOperation historyOperation, final BindingResult validationResult){
        if(validationResult.hasErrors()){
            return "/historyOperations/save";
        }
        historyOperationsRepository.save(historyOperation);
        return "redirect:all";
    }
}
