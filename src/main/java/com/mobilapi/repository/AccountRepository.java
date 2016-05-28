package com.mobilapi.repository;


import com.mobilapi.domain.customer.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository extends GenericRepository<Account> {

    public AccountRepository() {
        super(Account.class);
    }

    public Account findByEmail(String email){
        return getDatastore().find(Account.class).filter("email",email).get();
    }
}
