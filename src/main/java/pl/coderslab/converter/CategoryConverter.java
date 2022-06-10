package pl.coderslab.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.AccountDetails;
import pl.coderslab.model.Categories;
import pl.coderslab.repository.AccountDetailsRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.Optional;

public class CategoryConverter implements Converter<String, Optional<Categories>> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Categories> convert(String source) {
        return categoryRepository.findById(Long.parseLong(source));
    }
}


