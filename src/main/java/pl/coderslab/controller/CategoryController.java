package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Categories;
import pl.coderslab.model.HistoryOperation;
import pl.coderslab.model.User;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.HistoryOperationsRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final HistoryOperationsRepository historyOperationsRepository;

    public CategoryController(CategoryRepository categoryRepository, UserRepository userRepository, HistoryOperationsRepository historyOperationsRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.historyOperationsRepository = historyOperationsRepository;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Categories> categories = categoryRepository.findAll();
        model.addAttribute("category", categories);
        return "/category/all";
    }

    @GetMapping("/allbyid/{id}/{id2}")
    public String showAll(Model model, @PathVariable long id, @PathVariable long id2){
        List<HistoryOperation> historyOperations = historyOperationsRepository.findAll();
        List<HistoryOperation> finalHistoryOperation = new ArrayList<>();
        for (int i =0; i < historyOperations.size(); i++){
            if(id == historyOperations.get(i).getAccount().getId() && id2 == historyOperations.get(i).getCategory().getId()){
                finalHistoryOperation.add(historyOperations.get(i));
            }
        }

        model.addAttribute("finalHistoryOperation", finalHistoryOperation);
        return "/category/allbyid";
    }



    @GetMapping("/save")
    public String save(Model model){
        model.addAttribute("category",new Categories());

        List<Categories> categories1 = categoryRepository.findAll();
        if (categories1.size() == 0) {
            Categories categories = new Categories();
            categories.setCategory("New Funds");
            categoryRepository.save(categories);
        }
        return "/category/save";
    }

    @PostMapping("/save")
    public String getForm(@Valid final Categories category, final BindingResult validationResult){
        if(validationResult.hasErrors()){
            return "/category/save";
        }
        categoryRepository.save(category);
        return "redirect:all";
    }
}
