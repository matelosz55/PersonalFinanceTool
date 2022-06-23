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
import pl.coderslab.model.Subcategories;
import pl.coderslab.model.User;
import pl.coderslab.repository.HistoryOperationsRepository;
import pl.coderslab.repository.SubcategoryRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/subcategory")
public class SubcategoryController {

    private final SubcategoryRepository subcategoryRepository;
    private final HistoryOperationsRepository historyOperationsRepository;

    public SubcategoryController(SubcategoryRepository subcategoryRepository, HistoryOperationsRepository historyOperationsRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.historyOperationsRepository = historyOperationsRepository;
    }


    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Subcategories> subcategories = subcategoryRepository.findAll();
        model.addAttribute("subcategory", subcategories);
        return "/subcategory/all";
    }

    @GetMapping("/allbyid/{id}/{id2}")
    public String showAll(Model model, @PathVariable long id, @PathVariable long id2){
        List<HistoryOperation> historyOperations = historyOperationsRepository.findAll();
        List<HistoryOperation> finalHistoryOperation = new ArrayList<>();
        for (int i =0; i < historyOperations.size(); i++){
            if(id == historyOperations.get(i).getAccount().getId() && id2 == historyOperations.get(i).getSubcategory().getId()){
                finalHistoryOperation.add(historyOperations.get(i));
            }
        }
        model.addAttribute("finalHistoryOperation", finalHistoryOperation);
        return "/subcategory/allbyid";
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
