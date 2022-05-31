package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.AccountDetails;


public interface AccountDetailsRepository extends JpaRepository<AccountDetails,Long> {
}
