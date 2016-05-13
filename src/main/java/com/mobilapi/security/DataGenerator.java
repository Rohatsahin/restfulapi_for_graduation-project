package com.mobilapi.security;


import com.mobilapi.domain.customer.Account;
import com.mobilapi.domain.enums.UserRole;
import com.mobilapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataGenerator {

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @PostConstruct
    public void init() {

        if(accountRepository.findByEmail("ommifood@gmail.com") == null) {
            Account account = new Account();

            account.setEmail("ommifood@gmail.com");
            account.setPassword(passwordEncoder.encodePassword("12345", null));
            account.setCity("California");
            account.setDistrict("Mazgirt");
            account.setFirstName("rohat");
            account.setLastName("sahin");
            account.setUserRole(UserRole.User);
            account.setPhone("09008006092");
            accountRepository.save(account);
        }
    }
}
