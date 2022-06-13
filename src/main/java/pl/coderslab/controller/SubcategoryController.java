package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Categories;
import pl.coderslab.model.Subcategories;
import pl.coderslab.repository.SubcategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/subcategory")
public class SubcategoryController {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryController(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }


    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Subcategories> subcategories = subcategoryRepository.findAll();
        model.addAttribute("subcategory", subcategories);
        return "/subcategory/all";
    }

    @GetMapping("/save")
    public String save(Model model){
        model.addAttribute("subcategory",new Subcategories());
        List<Subcategories> subcategories1 = subcategoryRepository.findAll();
        if (subcategories1.size() == 0) {
            Subcategories subcategories = new Subcategories();
            subcategories.setSubcategory("New Funds");
            subcategoryRepository.save(subcategories);
        }
        return "/subcategory/save";
    }

    @PostMapping("/save")
    public String getForm(@Valid final Subcategories subcategory, final BindingResult validationResult){
        if(validationResult.hasErrors()){
            return "/subcategory/save";
        }
        subcategoryRepository.save(subcategory);
        return "redirect:all";
    }
}
