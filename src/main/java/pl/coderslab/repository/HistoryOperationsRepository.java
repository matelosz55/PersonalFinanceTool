package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.HistoryOperation;


public interface HistoryOperationsRepository extends JpaRepository<HistoryOperation,Long> {
}
