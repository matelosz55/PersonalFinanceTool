package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pl.coderslab.model.Categories;
import pl.coderslab.model.HistoryOperation;

public interface CategoryRepository extends JpaRepository<Categories,Long> {
}
