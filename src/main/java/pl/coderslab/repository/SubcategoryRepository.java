package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Categories;
import pl.coderslab.model.Subcategories;

public interface SubcategoryRepository extends JpaRepository<Subcategories,Long> {
}
