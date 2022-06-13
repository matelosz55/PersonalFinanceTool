package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.AccountDetails;
import pl.coderslab.model.Categories;
import pl.coderslab.model.User;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Categories> categories = categoryRepository.findAll();
        model.addAttribute("category", categories);
        return "/category/all";
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
