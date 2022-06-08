package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.*;
import pl.coderslab.repository.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryOperationController {
    private final HistoryOperationsRepository historyOperationsRepository;
    private final AccountDetailsRepository accountDetailsRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    public HistoryOperationController(HistoryOperationsRepository historyOperationsRepository, UserRepository userRepository, AccountDetailsRepository accountDetailsRepository, CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository) {
        this.historyOperationsRepository = historyOperationsRepository;
        this.accountDetailsRepository = accountDetailsRepository;
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
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
        List<AccountDetails> accounts = accountDetailsRepository.findAll();
        List<Categories> categories = categoryRepository.findAll();
        List<Subcategories> subcategories = subcategoryRepository.findAll();
        model.addAttribute("accounts",accounts);
        model.addAttribute("subcategory",subcategories);
        model.addAttribute("category",categories);
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
