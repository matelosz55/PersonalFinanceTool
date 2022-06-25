package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.repository.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
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
    public String showExpenses(Model model) {
        List<HistoryOperation> historyOperations = historyOperationsRepository.findAll();
        model.addAttribute("historyOperation", historyOperations);
        return "/historyOperations/all";
    }

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("historyOperation", new HistoryOperation());
        List<AccountDetails> accounts = accountDetailsRepository.findAll();
        List<Categories> categories = categoryRepository.findAll();
        List<Subcategories> subcategories = subcategoryRepository.findAll();
        model.addAttribute("accounts", accounts);
        model.addAttribute("subcategories", subcategories);
        model.addAttribute("categories", categories);
        return "/historyOperations/save";
    }

    @PostMapping("/save")
    @Transactional
    public String getForm(@Valid final HistoryOperation historyOperation, final BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            return "/historyOperations/save";
        }
        Double value = historyOperation.getCashValue();
        Long id = historyOperation.getAccount().getId();
        AccountDetails account = accountDetailsRepository.getOne(id);
        double accountValue = account.getAccountValue();
        if (historyOperation.getOperationType().equals("add_funds")) {
            account.setAccountValue(account.getAccountValue() + value);
        } else if (accountValue >= value) {
            account.setAccountValue(account.getAccountValue() - value);
        } else {
            return "/historyOperations/nomoney";
        }
        accountDetailsRepository.save(account);
        historyOperationsRepository.save(historyOperation);
        return "redirect:all";
    }

    @GetMapping("/get/{id}")
    public String getOne(Model model, @PathVariable long id) {
        List<HistoryOperation> historyOperationsPrimary = historyOperationsRepository.findAll();
        List<HistoryOperation> historyOperations = new ArrayList<>();
        for (int i = 0; i < historyOperationsPrimary.size(); i++) {
            if (historyOperationsPrimary.get(i).getAccount().getId() == id) {
                historyOperations.add(historyOperationsPrimary.get(i));
            }
        }
        model.addAttribute("historyOperation", historyOperations);
        return "/historyOperations/all";
    }

    @GetMapping("delete/{id}")
    @Transactional
    public String delete(Model model, @PathVariable long id) {
        HistoryOperation historyOperation = historyOperationsRepository.getOne(id);
        Double value = historyOperation.getCashValue();
        Long accountId = historyOperation.getAccount().getId();
        AccountDetails account = accountDetailsRepository.getOne(accountId);
        double accountValue = account.getAccountValue();
        if (historyOperation.getOperationType().equals("add_funds")) {
            account.setAccountValue(account.getAccountValue() - value);
        } else if (accountValue >= value) {
            account.setAccountValue(account.getAccountValue() + value);
        }
        historyOperationsRepository.deleteById(id);
        List<HistoryOperation> historyOperations = historyOperationsRepository.findAll();
        model.addAttribute("historyOperation", historyOperations);
        return "/historyOperations/all";
    }


}
