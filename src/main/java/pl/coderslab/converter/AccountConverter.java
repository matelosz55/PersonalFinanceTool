package pl.coderslab.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.AccountDetails;
import pl.coderslab.repository.AccountDetailsRepository;

import java.util.Optional;

import static java.lang.Long.parseLong;

public class AccountConverter implements Converter<String, Optional<AccountDetails>> {

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    @Override
    public Optional<AccountDetails> convert(String source) {
        return accountDetailsRepository.findById(Long.parseLong(source));
    }
}


