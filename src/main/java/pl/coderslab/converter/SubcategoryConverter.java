package pl.coderslab.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Categories;
import pl.coderslab.model.Subcategories;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.SubcategoryRepository;

import java.util.Optional;

public class SubcategoryConverter implements Converter<String, Optional<Subcategories>> {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public Optional<Subcategories> convert(String source) {
        return subcategoryRepository.findById(Long.parseLong(source));
    }
}


