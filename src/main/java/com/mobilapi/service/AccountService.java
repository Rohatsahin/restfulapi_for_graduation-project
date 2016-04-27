package com.mobilapi.service;


import com.mobilapi.domain.customer.Account;
import com.mobilapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;


    public Account findByEmail(String email) {
        Account account = accountRepository.findByEmail(email);

        return account;
    }

    public Account saveUser(Account account) {
        String hashed_password = passwordEncoder.encodePassword(account.getPassword(), null);
        account.setPassword(hashed_password);
        return accountRepository.save(account);
    }

    public boolean emailNotRegistered(String email) {
        return accountRepository.findByEmail(email) == null;
    }


}
